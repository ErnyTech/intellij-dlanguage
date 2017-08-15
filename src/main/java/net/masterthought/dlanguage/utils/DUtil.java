package net.masterthought.dlanguage.utils;

import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFile;
import com.intellij.psi.stubs.StubElement;
import com.intellij.psi.tree.IElementType;
import com.intellij.psi.util.PsiTreeUtil;
import net.masterthought.dlanguage.psi.*;
import net.masterthought.dlanguage.psi.interfaces.DNamedElement;
import net.masterthought.dlanguage.psi.interfaces.HasVisibility;
import net.masterthought.dlanguage.stubs.*;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.*;

import static net.masterthought.dlanguage.psi.interfaces.HasVisibility.Visibility.*;

/**
 * General util class. Provides methods for finding named nodes in the Psi tree.
 */
public class DUtil {

//    public static Map<Boolean, PsiElement> findElementInParent(PsiElement identifier, Class className) {
//        PsiElement result = findParentOfType(identifier, className);
//        Map<Boolean, PsiElement> map = new HashMap<>();
//        map.put(result != null, result);
//        return map;
//    }

    public static Boolean elementHasParentFor(final Map<Boolean, PsiElement> result) {
        return result.containsKey(true);
    }

    public static PsiElement getElementFor(final Map<Boolean, PsiElement> result) {
        return (PsiElement) result.values().toArray()[0];
    }


    //    public static boolean definitionNode(@NotNull DDefinitionClass e) {
//        return true;
//    }


    public static boolean isNotNullOrEmpty(final String str) {
        return (str != null && !str.isEmpty());
    }

//    @Nullable
//    public static String getQualifiedPrefix(@NotNull PsiElement e) {
//        final PsiElement q = PsiTreeUtil.getParentOfType(e, DLanguageFunctionDeclaration.class);
//        if (q == null) {
//            return null;
//        }
//        final String qText = q.getText();
//        final int lastDotPos = qText.lastIndexOf('.');
//        if (lastDotPos == -1) {
//            return null;
//        }
//        return qText.substring(0, lastDotPos);
//    }

//    @NotNull
//    public static Set<String> getPotentialDefinitionModuleNames(@NotNull PsiElement e, @NotNull List<String> imports) {
//        final String qPrefix = getQualifiedPrefix(e);
//        if (qPrefix == null) { return DPsiUtil.getImportModuleNames(imports); }
//        Set<String> result = new HashSet<String>();
//        for (DPsiUtil.Import anImport : imports) {
//            if (qPrefix.equals(anImport.module) || qPrefix.equals(anImport.alias)) {
//                result.add(anImport.module);
//            }
//        }
//        return result;
//    }


    public static boolean isDunitTestFile(final PsiFile psiFile) {
        final Collection<DLanguageClassDeclaration> cds = PsiTreeUtil.findChildrenOfType(psiFile, DLanguageClassDeclaration.class);
        for (final DLanguageClassDeclaration cd : cds) {
            // if a class contains the UnitTest mixin assume its a valid d-unit test class
            final Collection<DLanguageTemplateMixinExpression> tmis = PsiTreeUtil.findChildrenOfType(cd, DLanguageTemplateMixinExpression.class);
            for (final DLanguageTemplateMixinExpression tmi : tmis) {
                if (tmi.getText().contains("UnitTest")) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * @param namedElement constructor, or method contained within a class or struct
     * @return the class or struct containing this constructor/method. returns null if not found
     */
    public static DNamedElement getParentClassOrStructOrTemplateOrInterfaceOrUnion(final PsiElement namedElement) {
        return PsiTreeUtil.getParentOfType(namedElement, DLanguageInterfaceOrClass.class, DLanguageStructDeclaration.class, DLanguageTemplateDeclaration.class, DLanguageUnionDeclaration.class);
    }

    public static DLanguageFunctionDeclaration getParentFunction(final PsiElement namedElement) {
        return PsiTreeUtil.getParentOfType(namedElement, DLanguageFunctionDeclaration.class);
    }

//    public static boolean isPublic(DNamedElement symbol) {
//        //search for "public:" and "public{}"
//        final DLanguageProtectionAttribute protectionAttribute = findChildOfType(symbol, DLanguageProtectionAttribute.class);
//        try {
//            if (protectionAttribute.getText().equals("public")) {
//                return true;
//            }
//        } catch (NullPointerException ignored) {
//        }
//        return searchForPublicWrapper(symbol);
//    }
//
//    private static boolean searchForPublicWrapper(DNamedElement symbol) {
//        return searchForPublic(symbol);
//    }
//
//    private static boolean searchForPublic(PsiElement symbol) {
//        if (symbol instanceof DLanguageAttributeSpecifier)
//            if (((DLanguageAttributeSpecifier) symbol).getAttribute().getProtectionAttribute() != null && ((DLanguageAttributeSpecifier) symbol).getAttribute().getProtectionAttribute().getText().equals("public"))
//                return true;
//        if (symbol instanceof DLanguageClassDeclaration || symbol instanceof DLanguageTemplateInstance || symbol instanceof DLanguageModuleDeclaration || symbol instanceof DLanguageFunctionDeclaration || symbol instanceof DLanguageInterface || symbol instanceof DLanguageStructDeclaration)
//            return false;
//        if (symbol == null)
//            return false;
//        if (null != findChildOfType(symbol, DLanguageModuleDeclaration.class))
//            return false;
//        return searchForPublic(symbol.getParent());
//    }

    public static <T extends HasVisibility> List<T> getPublicElements(final List<T> elements) {
        final List<T> res = new ArrayList<>();
        for (final T element : elements) {
            if (element.isPublic()) {
                res.add(element);
            }
        }
        return res;
    }

    public static <T extends HasVisibility> List<T> getProtectedElements(final List<T> elements) {
        final List<T> res = new ArrayList<>();
        for (final T element : elements) {
            if (element.isPublic()) {
                res.add(element);
            }
        }
        return res;
    }

    public static <T extends HasVisibility> List<T> getPrivateElements(final List<T> elements) {
        final List<T> res = new ArrayList<>();
        for (final T element : elements) {
            if (element.isPublic()) {
                res.add(element);
            }
        }
        return res;
    }

    @NotNull
    public static PsiElement getTopLevelOfRecursiveElement(final PsiElement element, final Class<? extends PsiElement> tClass) {
        if (!tClass.isInstance(element.getParent()))
            return element;
        return getTopLevelOfRecursiveElement(element.getParent(), tClass);
    }

//    @NotNull
//    public static DLanguageIdentifier getEndOfIdentifierList(DLanguageQualifiedIdentifierList list) {
//        return (DLanguageIdentifier) (list.getChildren()[list.getChildren().length - 1]);//if not identifier through
//    }
//
//    @NotNull
//    public static DLanguageIdentifier getEndOfIdentifierList(DLanguageModuleFullyQualifiedName list) {
//        if (list.getModuleFullyQualifiedName() == null) {
//            return list.getIdentifier();
//        }
//        return getEndOfIdentifierList(list.getModuleFullyQualifiedName());
//    }
//
//    @NotNull
//    public static DLanguageIdentifier getEndOfIdentifierList(DLanguageIdentifierList list) {
//        if (list.getIdentifierList() == null) {
//            return list.getIdentifier();
//        }
//        return getEndOfIdentifierList(list.getIdentifierList());
//    }

//    static List<Mixin> getMixins(PsiElement elementToSearch) {
//        List<Mixin> mixins = new ArrayList<>();
//        if (elementToSearch instanceof DLanguageMixinDeclaration) {
//            final DLanguageMixinDeclaration mixin = (DLanguageMixinDeclaration) elementToSearch;
//            mixins.add(mixin);
//        }
//        if (elementToSearch instanceof DLanguageTemplateMixin) {
//            final DLanguageTemplateMixin mixin = (DLanguageTemplateMixin) elementToSearch;
//            mixins.add(mixin);
//        }
//        if (elementToSearch instanceof DLanguageMixinExpression) {
//            final DLanguageMixinExpression mixin = (DLanguageMixinExpression) elementToSearch;
//            mixins.add(mixin);
//        }
//        if (elementToSearch instanceof DLanguageMixinStatement) {
//            final DLanguageMixinStatement mixin = (DLanguageMixinStatement) elementToSearch;
//            mixins.add(mixin);
//        }
//        return mixins;
//    }

    public static HasVisibility.Visibility protectionToVisibilty(final DLanguageAttribute protectionAttribute) {
        final String text = protectionAttribute.getText();
        if (text.equals("private"))
            return private_;
        if (text.equals("public"))
            return public_;
        if (text.equals("protected"))
            return protected_;
        throw new IllegalArgumentException(protectionAttribute.toString() + protectionAttribute.getText());
    }

    public static HasVisibility.Visibility protectionToVisibilty(final String text) {
        if (text.equals("private"))
            return private_;
        if (text.equals("public"))
            return public_;
        if (text.equals("protected"))
            return protected_;
        throw new IllegalArgumentException(text);

    }

    public static DLanguageIdentifier getEndOfIdentifierList(final DLanguageIdentifierOrTemplateChain chain) {
        final List<DLanguageIdentifierOrTemplateInstance> list = chain.getIdentifierOrTemplateInstances();
        if (list.get(list.size() - 1).getIdentifier() != null)
            return list.get(list.size() - 1).getIdentifier();
        else
            throw new IllegalStateException();

    }


    public static ASTNode getPrevSiblingOfType(@Nullable final ASTNode child, @Nullable final IElementType type) {
        if (child == null)
            return null;
        if (child.getElementType() == type) {
            return child.getTreePrev();
        }
        return getPrevSiblingOfType(child.getTreePrev(), type);
    }

    @Nullable
    public static ASTNode getPrevSiblingOfType(@Nullable final ASTNode child, @NotNull final HashSet<IElementType> newHashSet, @NotNull final HashSet<IElementType> excluded) {
        if (child == null)
            return null;
        if (newHashSet.contains(child.getElementType())) {
            return child;
        }
        if (excluded.contains(child.getElementType())) {
            return null;
        }
        return getPrevSiblingOfType(child.getTreePrev(), newHashSet, excluded);
    }

    @Nullable
    public static PsiElement findParentOfType(final PsiElement element, final Class className) {
        if (className.isInstance(element)) {
            return element;
        } else {
            try {
                return findParentOfType(element.getParent(), className);
            } catch (final Exception e) {
                return null;
            }
        }

    }

    public static DLanguageIdentifier getEndOfIdentifierList(final DLanguageIdentifierChain chain) {
        final List<DLanguageIdentifier> list = chain.getIdentifiers();
        if (list.get(list.size() - 1) != null)
            return list.get(list.size() - 1);
        else
            throw new IllegalStateException();
    }

    @Nullable
    public static DNamedStubBase getParentClassOrStructOrTemplateOrInterfaceOrUnionStub(final @NotNull StubElement stub) {
        if (stub.getParentStub() == null) {
            return null;
        }
        return getParentClassOrStructOrTemplateOrInterfaceOrUnionStubImpl(stub.getParentStub());
    }

    @Nullable
    private static DNamedStubBase getParentClassOrStructOrTemplateOrInterfaceOrUnionStubImpl(final @NotNull StubElement stub) {
        if (stub instanceof DLanguageUnionDeclarationStub || stub instanceof DLanguageInterfaceOrClassStub || stub instanceof DLanguageStructDeclarationStub || stub instanceof DLanguageTemplateDeclarationStub) {
            return (DNamedStubBase) stub;
        }
        if (stub.getParentStub() == null) {
            return null;
        }
        return getParentClassOrStructOrTemplateOrInterfaceOrUnionStubImpl(stub.getParentStub());
    }
}

