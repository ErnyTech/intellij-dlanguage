package io.github.intellij.dlanguage.psi.impl;

import com.intellij.extapi.psi.ASTWrapperPsiElement;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import io.github.intellij.dlanguage.psi.DlangTypes;
import io.github.intellij.dlanguage.psi.DlangIdentifier;
import io.github.intellij.dlanguage.psi.DLanguageIdentifierChain;
import io.github.intellij.dlanguage.psi.DlangVisitor;
import org.jetbrains.annotations.NotNull;

import java.util.List;

import static io.github.intellij.dlanguage.psi.DlangTypes.OP_DOT;


public class DLanguageIdentifierChainImpl extends ASTWrapperPsiElement implements DLanguageIdentifierChain {
    public DLanguageIdentifierChainImpl(ASTNode node) {
        super(node);
    }

    public void accept(@NotNull DlangVisitor visitor) {
        visitor.visitIdentifierChain(this);
    }

    public void accept(@NotNull PsiElementVisitor visitor) {
        if (visitor instanceof DlangVisitor) accept((DlangVisitor) visitor);
        else super.accept(visitor);
    }

    @NotNull
    public List<DlangIdentifier> getIdentifiers() {
        return PsiTreeUtil.getChildrenOfTypeAsList(this, DlangIdentifier.class);
    }

    @NotNull
    public List<PsiElement> getOP_DOTs() {
        return findChildrenByType(DlangTypes.OP_DOT);
    }

}