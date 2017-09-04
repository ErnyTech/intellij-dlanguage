package net.masterthought.dlanguage.psi;

import com.intellij.psi.PsiElement;
import org.jetbrains.annotations.NotNull;

import java.util.List;


public interface DLanguageAsmTypePrefix extends PsiElement {
    @NotNull
    public List<DLanguageIdentifier> getIdentifiers();
}
