package net.masterthought.dlanguage.psi;

import com.intellij.psi.PsiElement;
import org.jetbrains.annotations.NotNull;

import java.util.List;


public interface DLanguageArgumentList extends PsiElement {
    @NotNull
    public List<DLanguageAssignExpression> getAssignExpressions();

    @NotNull
    public List<PsiElement> getOP_COMMAs();

}
