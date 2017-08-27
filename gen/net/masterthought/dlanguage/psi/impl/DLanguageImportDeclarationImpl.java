

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



public class DLanguageImportDeclarationImpl extends ASTWrapperPsiElement implements DLanguageImportDeclaration{
       public DLanguageImportDeclarationImpl (ASTNode node){
               super(node);
       }
       public void accept(@NotNull DLanguageVisitor visitor){
           visitor.visitImportDeclaration(this);
       }
       public void accept(@NotNull PsiElementVisitor visitor){
           if(visitor instanceof DLanguageVisitor) accept((DLanguageVisitor)visitor);
           else super.accept(visitor);
       }

            @Nullable
            public PsiElement getKW_IMPORT() {
                return findChildByType(KW_IMPORT);
            }
        
                @NotNull
                public List<DLanguageSingleImport> getSingleImports() {
                    return PsiTreeUtil.getChildrenOfTypeAsList(this, DLanguageSingleImport.class);
                }
            @Nullable
            public DLanguageImportBindings getImportBindings() {
                return PsiTreeUtil.getChildOfType(this, DLanguageImportBindings.class);
            }
                @NotNull
                public List<PsiElement> getOP_COMMAs() {
                    return findChildrenByType(OP_COMMA);
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