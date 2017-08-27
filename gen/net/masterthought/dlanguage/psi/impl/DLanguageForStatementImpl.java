

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



public class DLanguageForStatementImpl extends ASTWrapperPsiElement implements DLanguageForStatement{
       public DLanguageForStatementImpl (ASTNode node){
               super(node);
       }
       public void accept(@NotNull DLanguageVisitor visitor){
           visitor.visitForStatement(this);
       }
       public void accept(@NotNull PsiElementVisitor visitor){
           if(visitor instanceof DLanguageVisitor) accept((DLanguageVisitor)visitor);
           else super.accept(visitor);
       }

                @NotNull
                public List<DLanguageDeclarationOrStatement> getDeclarationOrStatements() {
                    return PsiTreeUtil.getChildrenOfTypeAsList(this, DLanguageDeclarationOrStatement.class);
                }
                @NotNull
                public List<DLanguageExpression> getExpressions() {
                    return PsiTreeUtil.getChildrenOfTypeAsList(this, DLanguageExpression.class);
                }
            @Nullable
            public PsiElement getOP_BRACES_RIGHT() {
                return findChildByType(OP_BRACES_RIGHT);
            }
        
            @Nullable
            public PsiElement getOP_BRACES_LEFT() {
                return findChildByType(OP_BRACES_LEFT);
            }
        
            @Nullable
            public PsiElement getKW_FOR() {
                return findChildByType(KW_FOR);
            }
        
            @Nullable
            public PsiElement getOP_SCOLON() {
                return findChildByType(OP_SCOLON);
            }
        
            @Override
            public boolean processDeclarations(@NotNull PsiScopeProcessor processor,
                                             @NotNull ResolveState state,
                                             PsiElement lastParent,
                                             @NotNull PsiElement place) {
                return ScopeProcessorImpl.INSTANCE.processDeclarations(this,processor,state,lastParent,place);
            }
}