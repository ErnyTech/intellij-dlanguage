

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



public class DLanguageCastQualifierImpl extends ASTWrapperPsiElement implements DLanguageCastQualifier{
       public DLanguageCastQualifierImpl (ASTNode node){
               super(node);
       }
       public void accept(@NotNull DLanguageVisitor visitor){
           visitor.visitCastQualifier(this);
       }
       public void accept(@NotNull PsiElementVisitor visitor){
           if(visitor instanceof DLanguageVisitor) accept((DLanguageVisitor)visitor);
           else super.accept(visitor);
       }

            @Nullable
            public PsiElement getKW_IMMUTABLE() {
                return findChildByType(KW_IMMUTABLE);
            }
        
            @Nullable
            public PsiElement getKW_CONST() {
                return findChildByType(KW_CONST);
            }
        
            @Nullable
            public PsiElement getKW_SHARED() {
                return findChildByType(KW_SHARED);
            }
        
            @Nullable
            public PsiElement getKW_INOUT() {
                return findChildByType(KW_INOUT);
            }
        
}