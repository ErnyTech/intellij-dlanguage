

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



public class DLanguageStatementImpl extends ASTWrapperPsiElement implements DLanguageStatement{
       public DLanguageStatementImpl (ASTNode node){
               super(node);
       }
       public void accept(@NotNull DLanguageVisitor visitor){
           visitor.visitStatement(this);
       }
       public void accept(@NotNull PsiElementVisitor visitor){
           if(visitor instanceof DLanguageVisitor) accept((DLanguageVisitor)visitor);
           else super.accept(visitor);
       }

            @Nullable
            public DLanguageDefaultStatement getDefaultStatement() {
                return PsiTreeUtil.getChildOfType(this, DLanguageDefaultStatement.class);
            }
            @Nullable
            public DLanguageStatementNoCaseNoDefault getStatementNoCaseNoDefault() {
                return PsiTreeUtil.getChildOfType(this, DLanguageStatementNoCaseNoDefault.class);
            }
            @Nullable
            public DLanguageCaseStatement getCaseStatement() {
                return PsiTreeUtil.getChildOfType(this, DLanguageCaseStatement.class);
            }
            @Nullable
            public DLanguageCaseRangeStatement getCaseRangeStatement() {
                return PsiTreeUtil.getChildOfType(this, DLanguageCaseRangeStatement.class);
            }
}