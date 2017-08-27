

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



public class DLanguageAsmInstructionImpl extends ASTWrapperPsiElement implements DLanguageAsmInstruction{
       public DLanguageAsmInstructionImpl (ASTNode node){
               super(node);
       }
       public void accept(@NotNull DLanguageVisitor visitor){
           visitor.visitAsmInstruction(this);
       }
       public void accept(@NotNull PsiElementVisitor visitor){
           if(visitor instanceof DLanguageVisitor) accept((DLanguageVisitor)visitor);
           else super.accept(visitor);
       }

            @Nullable
            public PsiElement getINTEGER_LITERAL() {
                return findChildByType(INTEGER_LITERAL);
            }
        
            @Nullable
            public DLanguageIdentifier getIdentifier() {
                return PsiTreeUtil.getChildOfType(this, DLanguageIdentifier.class);
            }
            @Nullable
            public DLanguageAsmInstruction getAsmInstruction() {
                return PsiTreeUtil.getChildOfType(this, DLanguageAsmInstruction.class);
            }
            @Nullable
            public DLanguageOperands getOperands() {
                return PsiTreeUtil.getChildOfType(this, DLanguageOperands.class);
            }
            @Nullable
            public PsiElement getKW_ALIGN() {
                return findChildByType(KW_ALIGN);
            }
        
            @Nullable
            public PsiElement getOP_COLON() {
                return findChildByType(OP_COLON);
            }
        
}