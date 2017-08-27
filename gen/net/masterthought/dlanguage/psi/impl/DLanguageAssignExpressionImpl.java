package net.masterthought.dlanguage.psi.impl;

import com.intellij.extapi.psi.ASTWrapperPsiElement;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import net.masterthought.dlanguage.psi.DLanguageAssignExpression;
import net.masterthought.dlanguage.psi.DLanguageTernaryExpression;
import net.masterthought.dlanguage.psi.DLanguageVisitor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import static net.masterthought.dlanguage.psi.DLanguageTypes.*;


public class DLanguageAssignExpressionImpl extends ASTWrapperPsiElement implements DLanguageAssignExpression {
    public DLanguageAssignExpressionImpl(ASTNode node) {
        super(node);
    }

    public void accept(@NotNull DLanguageVisitor visitor) {
        visitor.visitAssignExpression(this);
    }

    public void accept(@NotNull PsiElementVisitor visitor) {
        if (visitor instanceof DLanguageVisitor) accept((DLanguageVisitor) visitor);
        else super.accept(visitor);
    }

    @Nullable
    public DLanguageTernaryExpression getTernaryExpression() {
        return PsiTreeUtil.getChildOfType(this, DLanguageTernaryExpression.class);
    }

    @Nullable
    public DLanguageAssignExpression getAssignExpression() {
        return PsiTreeUtil.getChildOfType(this, DLanguageAssignExpression.class);
    }

    @Nullable
    public PsiElement getOP_AND_EQ() {
        return findChildByType(OP_AND_EQ);
    }

    @Nullable
    public PsiElement getOP_DIV_EQ() {
        return findChildByType(OP_DIV_EQ);
    }

    @Nullable
    public PsiElement getOP_EQ() {
        return findChildByType(OP_EQ);
    }

    @Nullable
    public PsiElement getOP_EQ_EQ() {
        return findChildByType(OP_EQ_EQ);
    }

    @Nullable
    public PsiElement getOP_GT_EQ() {
        return findChildByType(OP_GT_EQ);
    }

    @Nullable
    public PsiElement getOP_LESS_EQ() {
        return findChildByType(OP_LESS_EQ);
    }

    @Nullable
    public PsiElement getOP_LESS_GR_EQ() {
        return findChildByType(OP_LESS_GR_EQ);
    }

    @Nullable
    public PsiElement getOP_MINUS_EQ() {
        return findChildByType(OP_MINUS_EQ);
    }

    @Nullable
    public PsiElement getOP_MOD_EQ() {
        return findChildByType(OP_MOD_EQ);
    }

    @Nullable
    public PsiElement getOP_MUL_EQ() {
        return findChildByType(OP_MUL_EQ);
    }

    @Nullable
    public PsiElement getOP_NOT_EQ() {
        return findChildByType(OP_NOT_EQ);
    }

    @Nullable
    public PsiElement getOP_NOT_GR_EQ() {
        return findChildByType(OP_NOT_GR_EQ);
    }

    @Nullable
    public PsiElement getOP_NOT_LESS_EQ() {
        return findChildByType(OP_NOT_LESS_EQ);
    }

    @Nullable
    public PsiElement getOP_OR_EQ() {
        return findChildByType(OP_OR_EQ);
    }

    @Nullable
    public PsiElement getOP_PLUS_EQ() {
        return findChildByType(OP_PLUS_EQ);
    }

    @Nullable
    public PsiElement getOP_POW_EQ() {
        return findChildByType(OP_POW_EQ);
    }

    @Nullable
    public PsiElement getOP_SH_LEFT_EQ() {
        return findChildByType(OP_SH_LEFT_EQ);
    }

    @Nullable
    public PsiElement getOP_SH_RIGHT_EQ() {
        return findChildByType(OP_SH_RIGHT_EQ);
    }

    @Nullable
    public PsiElement getOP_TILDA_EQ() {
        return findChildByType(OP_TILDA_EQ);
    }

    @Nullable
    public PsiElement getOP_UNORD_EQ() {
        return findChildByType(OP_UNORD_EQ);
    }

    @Nullable
    public PsiElement getOP_USH_RIGHT_EQ() {
        return findChildByType(OP_USH_RIGHT_EQ);
    }

    @Nullable
    public PsiElement getOP_XOR_EQ() {
        return findChildByType(OP_XOR_EQ);
    }

}
