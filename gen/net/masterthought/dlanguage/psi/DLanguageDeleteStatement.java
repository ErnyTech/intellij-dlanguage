package net.masterthought.dlanguage.psi;

import com.intellij.psi.PsiElement;
import org.jetbrains.annotations.Nullable;


public interface DLanguageDeleteStatement extends PsiElement {
    @Nullable
    public PsiElement getKW_DELETE();

}
