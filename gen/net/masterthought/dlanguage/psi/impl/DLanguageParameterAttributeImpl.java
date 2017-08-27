

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



public class DLanguageParameterAttributeImpl extends ASTWrapperPsiElement implements DLanguageParameterAttribute{
       public DLanguageParameterAttributeImpl (ASTNode node){
               super(node);
       }
       public void accept(@NotNull DLanguageVisitor visitor){
           visitor.visitParameterAttribute(this);
       }
       public void accept(@NotNull PsiElementVisitor visitor){
           if(visitor instanceof DLanguageVisitor) accept((DLanguageVisitor)visitor);
           else super.accept(visitor);
       }

            @Nullable
            public PsiElement getKW_FINAL() {
                return findChildByType(KW_FINAL);
            }
        
            @Nullable
            public PsiElement getKW_IN() {
                return findChildByType(KW_IN);
            }
        
            @Nullable
            public PsiElement getKW_LAZY() {
                return findChildByType(KW_LAZY);
            }
        
            @Nullable
            public PsiElement getKW_OUT() {
                return findChildByType(KW_OUT);
            }
        
            @Nullable
            public PsiElement getKW_REF() {
                return findChildByType(KW_REF);
            }
        
            @Nullable
            public PsiElement getKW_SCOPE() {
                return findChildByType(KW_SCOPE);
            }
        
            @Nullable
            public PsiElement getKW_AUTO() {
                return findChildByType(KW_AUTO);
            }
        
            @Nullable
            public DLanguageTypeConstructor getTypeConstructor() {
                return PsiTreeUtil.getChildOfType(this, DLanguageTypeConstructor.class);
            }
}