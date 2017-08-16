package net.masterthought.dlanguage.psi;

import com.intellij.psi.PsiElement;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;


public interface DLanguageIfStatement extends PsiElement {
    @NotNull
    public List<DLanguageDeclarationOrStatement> getDeclarationOrStatements();

    @Nullable
    public PsiElement getKW_ELSE();

    @Nullable
    public PsiElement getKW_IF();

    @Nullable
    public PsiElement getOP_PAR_LEFT();

    @Nullable
    public PsiElement getOP_PAR_RIGHT();

    @Nullable
    public DLanguageIfCondition getIfCondition();
}
