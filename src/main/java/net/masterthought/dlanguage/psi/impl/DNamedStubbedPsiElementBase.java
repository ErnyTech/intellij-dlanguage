package net.masterthought.dlanguage.psi.impl;

import com.intellij.lang.ASTNode;
import com.intellij.navigation.ItemPresentation;
import com.intellij.openapi.util.TextRange;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFile;
import com.intellij.psi.PsiReference;
import com.intellij.psi.stubs.IStubElementType;
import net.masterthought.dlanguage.attributes.DAttributes;
import net.masterthought.dlanguage.icons.DLanguageIcons;
import net.masterthought.dlanguage.psi.DLanguageFile;
import net.masterthought.dlanguage.psi.DLanguageIdentifier;
import net.masterthought.dlanguage.psi.interfaces.DNamedElement;
import net.masterthought.dlanguage.psi.references.DReference;
import net.masterthought.dlanguage.stubs.DNamedStubBase;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;

public abstract class DNamedStubbedPsiElementBase<T extends DNamedStubBase<?>> extends DStubbedPsiElementBase<T> implements DNamedElement {
    public DNamedStubbedPsiElementBase(@NotNull final T stub, final IStubElementType nodeType) {
        super(stub, nodeType);
    }

    public DNamedStubbedPsiElementBase(final ASTNode node) {
        super(node);
    }

    @Nullable
    public abstract DLanguageIdentifier getNameIdentifier();

    @NotNull
    public String getName() {
        if (getStub() != null) {
            if (getStub().getName() != null)
                return getStub().getName();
        }
        if (getNameIdentifier() == null) {
            return DReference.Companion.getNAME_NOT_FOUND_STRING();
        }
        return getNameIdentifier().getName();
    }

    @NotNull
    public PsiElement setName(@NotNull final String newName) {
        if (getNameIdentifier() == null)
            throw new IllegalStateException("Cannot rename. Identifier was Null");
        return getNameIdentifier().setName(newName);
    }

    public ItemPresentation getPresentation() {
        return new ItemPresentation() {
            @NotNull
            @Override
            public String getPresentableText() {
                return getName();
            }

            /**
             * This is needed to decipher between files when resolving multiple references.
             */
            @Nullable
            @Override
            public String getLocationString() {
                final PsiFile psiFile = getContainingFile();
                return psiFile instanceof DLanguageFile ? ((DLanguageFile) psiFile).getModuleOrFileName() : null;
            }

            @Nullable
            @Override
            public Icon getIcon(final boolean unused) {
                return DLanguageIcons.FILE;
            }
        };
    }

    @NotNull
    public PsiReference getReference() {
        return new DReference(this, TextRange.from(0, (this).getName().length()));
    }//not sure if this should only be implemented for identifier todo

    @NotNull
    @Override
    public DAttributes getAttributes() {
        if (getStub() != null) {
            return getStub().getAttributes();
        }
        final PsiElement startingElement;
        if (getNameIdentifier() != null)
            startingElement = getNameIdentifier();
        else
            startingElement = this;
        return new DAttributes(startingElement);

    }
}

