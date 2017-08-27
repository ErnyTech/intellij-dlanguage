

package net.masterthought.dlanguage.psi.impl;

import com.intellij.extapi.psi.ASTWrapperPsiElement;
import com.intellij.lang.ASTNode;
import com.intellij.psi.util.PsiTreeUtil;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import net.masterthought.dlanguage.psi.*;
import java.util.List;
import static net.masterthought.dlanguage.psi.DLanguageTypes.*;
import com.intellij.psi.ResolveState;
import com.intellij.psi.scope.PsiScopeProcessor;
import net.masterthought.dlanguage.resolve.ScopeProcessorImpl;



public class DLanguageNewExpressionImpl extends ASTWrapperPsiElement implements DLanguageNewExpression{
       public DLanguageNewExpressionImpl (ASTNode node){
               super(node);
       }
       public void accept(@NotNull DLanguageVisitor visitor){
           visitor.visitNewExpression(this);
       }
       public void accept(@NotNull PsiElementVisitor visitor){
           if(visitor instanceof DLanguageVisitor) accept((DLanguageVisitor)visitor);
           else super.accept(visitor);
       }

            @Nullable
            public PsiElement getKW_NEW() {
                return findChildByType(KW_NEW);
            }
        
            @Nullable
            public DLanguageNewAnonClassExpression getNewAnonClassExpression() {
                return PsiTreeUtil.getChildOfType(this, DLanguageNewAnonClassExpression.class);
            }
            @Nullable
            public DLanguageType getType() {
                return PsiTreeUtil.getChildOfType(this, DLanguageType.class);
            }
            @Nullable
            public DLanguageAssignExpression getAssignExpression() {
                return PsiTreeUtil.getChildOfType(this, DLanguageAssignExpression.class);
            }
            @Nullable
            public DLanguageArguments getArguments() {
                return PsiTreeUtil.getChildOfType(this, DLanguageArguments.class);
            }
            @Nullable
            public PsiElement getOP_BRACKET_LEFT() {
                return findChildByType(OP_BRACKET_LEFT);
            }
        
            @Nullable
            public PsiElement getOP_BRACKET_RIGHT() {
                return findChildByType(OP_BRACKET_RIGHT);
            }
        
}