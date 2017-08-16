package net.masterthought.dlanguage.psi;

import com.intellij.psi.PsiElement;
import org.jetbrains.annotations.NotNull;

import java.util.List;


public interface DLanguageTemplateArgumentList extends PsiElement {
    @NotNull
    public List<PsiElement> getOP_COMMAs();

    @NotNull
    public List<DLanguageTemplateArgument> getTemplateArguments();
}
