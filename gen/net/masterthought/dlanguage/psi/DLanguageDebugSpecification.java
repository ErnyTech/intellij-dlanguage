package net.masterthought.dlanguage.psi;

import com.intellij.psi.PsiElement;
import org.jetbrains.annotations.Nullable;


public interface DLanguageDebugSpecification extends PsiElement {
    @Nullable
    public PsiElement getKW_DEBUG();

    @Nullable
    public PsiElement getOP_EQ();

    @Nullable
    public DLanguageIdentifier getIdentifier();

    @Nullable
    public PsiElement getINTEGER_LITERAL();

    @Nullable
    public PsiElement getOP_SCOLON();

}
