package net.masterthought.dlanguage.psi.impl;

import com.intellij.extapi.psi.ASTWrapperPsiElement;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import net.masterthought.dlanguage.psi.DLanguageIdentifier;
import net.masterthought.dlanguage.psi.DLanguageTemplateSingleArgument;
import net.masterthought.dlanguage.psi.DLanguageType;
import net.masterthought.dlanguage.psi.DLanguageVisitor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import static net.masterthought.dlanguage.psi.DLanguageTypes.*;


public class DLanguageTemplateSingleArgumentImpl extends ASTWrapperPsiElement implements DLanguageTemplateSingleArgument {
    public DLanguageTemplateSingleArgumentImpl(ASTNode node) {
        super(node);
    }

    public void accept(@NotNull DLanguageVisitor visitor) {
        visitor.visitTemplateSingleArgument(this);
    }

    public void accept(@NotNull PsiElementVisitor visitor) {
        if (visitor instanceof DLanguageVisitor) accept((DLanguageVisitor) visitor);
        else super.accept(visitor);
    }

    @Nullable
    public DLanguageIdentifier getIdentifier() {
        return PsiTreeUtil.getChildOfType(this, DLanguageIdentifier.class);
    }

    @Nullable
    public DLanguageType getType() {
        return PsiTreeUtil.getChildOfType(this, DLanguageType.class);
    }

    @Nullable
    public PsiElement getKW_SUPER() {
        return findChildByType(KW_SUPER);
    }

    @Nullable
    public PsiElement getKW_THIS() {
        return findChildByType(KW_THIS);
    }

    @Nullable
    public PsiElement getOP_DOLLAR() {
        return findChildByType(OP_DOLLAR);
    }

    @Nullable
    public PsiElement getKW_TRUE() {
        return findChildByType(KW_TRUE);
    }

    @Nullable
    public PsiElement getKW_FALSE() {
        return findChildByType(KW_FALSE);
    }

    @Nullable
    public PsiElement getKW___DATE__() {
        return findChildByType(KW___DATE__);
    }

    @Nullable
    public PsiElement getKW___EOF__() {
        return findChildByType(KW___EOF__);
    }

    @Nullable
    public PsiElement getKW___FILE__() {
        return findChildByType(KW___FILE__);
    }

    @Nullable
    public PsiElement getKW___FILE_FULL_PATH__() {
        return findChildByType(KW___FILE_FULL_PATH__);
    }

    @Nullable
    public PsiElement getKW___FUNCTION__() {
        return findChildByType(KW___FUNCTION__);
    }

    @Nullable
    public PsiElement getKW___GSHARED() {
        return findChildByType(KW___GSHARED);
    }

    @Nullable
    public PsiElement getKW___LINE__() {
        return findChildByType(KW___LINE__);
    }

    @Nullable
    public PsiElement getKW___MODULE__() {
        return findChildByType(KW___MODULE__);
    }

    @Nullable
    public PsiElement getKW___PARAMETERS() {
        return findChildByType(KW___PARAMETERS);
    }

    @Nullable
    public PsiElement getKW___PRETTY_FUNCTION__() {
        return findChildByType(KW___PRETTY_FUNCTION__);
    }

    @Nullable
    public PsiElement getKW___TIME__() {
        return findChildByType(KW___TIME__);
    }

    @Nullable
    public PsiElement getKW___TIMESTAMP__() {
        return findChildByType(KW___TIMESTAMP__);
    }

    @Nullable
    public PsiElement getKW___TRAITS() {
        return findChildByType(KW___TRAITS);
    }

    @Nullable
    public PsiElement getKW___VECTOR() {
        return findChildByType(KW___VECTOR);
    }

    @Nullable
    public PsiElement getKW___VENDOR__() {
        return findChildByType(KW___VENDOR__);
    }

    @Nullable
    public PsiElement getKW___VERSION__() {
        return findChildByType(KW___VERSION__);
    }

    @Nullable
    public PsiElement getINTEGER_LITERAL() {
        return findChildByType(INTEGER_LITERAL);
    }

    @Nullable
    public PsiElement getFLOAT_LITERAL() {
        return findChildByType(FLOAT_LITERAL);
    }

    @Nullable
    public PsiElement getDOUBLE_QUOTED_STRING() {
        return findChildByType(DOUBLE_QUOTED_STRING);
    }

    @Nullable
    public PsiElement getCHARACTER_LITERAL() {
        return findChildByType(CHARACTER_LITERAL);
    }

}
