package net.masterthought.dlanguage.psi;

import com.intellij.psi.PsiElement;
import com.intellij.psi.ResolveState;
import com.intellij.psi.StubBasedPsiElement;
import com.intellij.psi.scope.PsiScopeProcessor;
import net.masterthought.dlanguage.psi.interfaces.DNamedElement;
import net.masterthought.dlanguage.resolve.ScopeProcessorImpl;
import net.masterthought.dlanguage.stubs.DLanguageFunctionDeclarationStub;
import net.masterthought.dlanguage.types.DType;
import net.masterthought.dlanguage.types.TypeOf;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;


public interface DLanguageFunctionDeclaration extends PsiElement, DNamedElement, StubBasedPsiElement<DLanguageFunctionDeclarationStub>, TypeOf {
    @Nullable
    DLanguageType getType();

    @Nullable
    DLanguageIdentifier getIdentifier();

    @Nullable
    DLanguageTemplateParameters getTemplateParameters();

    @Nullable
    DLanguageParameters getParameters();

    @Nullable
    DLanguageConstraint getConstraint();

    @Nullable
    DLanguageFunctionBody getFunctionBody();

    @NotNull
    DType getReturnType();

    @NotNull
    List<DLanguageStorageClass> getStorageClasses();

    @Override
    default boolean processDeclarations(@NotNull final PsiScopeProcessor processor,
                                        @NotNull final ResolveState state,
                                        final PsiElement lastParent,
                                        @NotNull final PsiElement place) {
        return ScopeProcessorImpl.INSTANCE.processDeclarations(this, processor, state, lastParent, place);
    }
}
