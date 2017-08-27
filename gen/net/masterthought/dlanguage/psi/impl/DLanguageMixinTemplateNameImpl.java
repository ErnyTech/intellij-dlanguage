package net.masterthought.dlanguage.psi.impl;

import com.intellij.extapi.psi.ASTWrapperPsiElement;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import net.masterthought.dlanguage.psi.*;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import static net.masterthought.dlanguage.psi.DLanguageTypes.OP_DOT;


public class DLanguageMixinTemplateNameImpl extends ASTWrapperPsiElement implements DLanguageMixinTemplateName {
    public DLanguageMixinTemplateNameImpl(ASTNode node) {
        super(node);
    }

    public void accept(@NotNull DLanguageVisitor visitor) {
        visitor.visitMixinTemplateName(this);
    }

    public void accept(@NotNull PsiElementVisitor visitor) {
        if (visitor instanceof DLanguageVisitor) accept((DLanguageVisitor) visitor);
        else super.accept(visitor);
    }

    @Nullable
    public DLanguageTypeofExpression getTypeofExpression() {
        return PsiTreeUtil.getChildOfType(this, DLanguageTypeofExpression.class);
    }

    @Nullable
    public DLanguageIdentifierOrTemplateChain getIdentifierOrTemplateChain() {
        return PsiTreeUtil.getChildOfType(this, DLanguageIdentifierOrTemplateChain.class);
    }

    @Nullable
    public DLanguageSymbol getSymbol() {
        return PsiTreeUtil.getChildOfType(this, DLanguageSymbol.class);
    }

    @Nullable
    public PsiElement getOP_DOT() {
        return findChildByType(OP_DOT);
    }

}
