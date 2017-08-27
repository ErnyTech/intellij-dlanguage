package net.masterthought.dlanguage.psi.impl;

import com.intellij.extapi.psi.ASTWrapperPsiElement;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import net.masterthought.dlanguage.psi.*;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;


public class DLanguageFunctionBodyImpl extends ASTWrapperPsiElement implements DLanguageFunctionBody {
    public DLanguageFunctionBodyImpl(ASTNode node) {
        super(node);
    }

    public void accept(@NotNull DLanguageVisitor visitor) {
        visitor.visitFunctionBody(this);
    }

    public void accept(@NotNull PsiElementVisitor visitor) {
        if (visitor instanceof DLanguageVisitor) accept((DLanguageVisitor) visitor);
        else super.accept(visitor);
    }

    @Nullable
    public DLanguageBlockStatement getBlockStatement() {
        return PsiTreeUtil.getChildOfType(this, DLanguageBlockStatement.class);
    }

    @Nullable
    public DLanguageInStatement getInStatement() {
        return PsiTreeUtil.getChildOfType(this, DLanguageInStatement.class);
    }

    @Nullable
    public DLanguageOutStatement getOutStatement() {
        return PsiTreeUtil.getChildOfType(this, DLanguageOutStatement.class);
    }

    @Nullable
    public DLanguageBodyStatement getBodyStatement() {
        return PsiTreeUtil.getChildOfType(this, DLanguageBodyStatement.class);
    }
}
