package net.masterthought.dlanguage.stubs.index

import com.intellij.openapi.project.Project
import com.intellij.psi.search.GlobalSearchScope
import com.intellij.psi.stubs.*
import net.masterthought.dlanguage.index.DModuleIndex
import net.masterthought.dlanguage.psi.interfaces.DNamedElement
import net.masterthought.dlanguage.stubs.*
import net.masterthought.dlanguage.stubs.interfaces.DLanguageUnittestStub
import net.masterthought.dlanguage.stubs.interfaces.HasMembersStub
import java.util.*

/**
 * Created by francis on 8/8/2017.
 * index contains members of string key. Does not handle inheritance/mixins
 */
class DMembersIndex : StringStubIndexExtension<DNamedElement>() {

    override fun getVersion(): Int {
        return super.getVersion() + VERSION
    }

    //use with caution, prefer static utility methods
    override fun getKey(): StubIndexKey<String, DNamedElement> {
        return KEY
    }

    companion object {
        private val KEY: StubIndexKey<String, DNamedElement> = StubIndexKey.createIndexKey<String, DNamedElement>("d.globally.members")
        val VERSION = 1
        fun <S : NamedStubBase<*>> indexMembers(stub: S, sink: IndexSink) {
            if (getParentHasMembers(stub).size > 1)
                return
            for (hasMembers in getParentHasMembers(stub)) {
                sink.occurrence(DMembersIndex.KEY, hasMembers.name)
            }
        }

        fun getMemberSymbols(name: String, module: String, project: Project, includeInheritance: Boolean = true): Set<DNamedElement> {
            val elements = mutableSetOf<DNamedElement>()
            for (file in DModuleIndex.getFilesByModuleName(project, module, GlobalSearchScope.everythingScope(project))) {
                elements.addAll(StubIndex.getElements(KEY, name, project, GlobalSearchScope.fileScope(file), DNamedElement::class.java))//todo assert that this should only be called once
//                if (includeInheritance) {
//                    for (element in DTopLevelDeclarationsByModuleAndName.getSymbol(name, file.moduleOrFileName, project)) {
//                        if (element is InterfaceOrClass) {
//                            element
//                        }
//                    }
//                }
            }
            return elements
        }

        private fun getParentHasMembers(stub: Stub): Set<HasMembersStub> {
            val result = HashSet<HasMembersStub>()
            getParentHasMembersImpl(stub, result)
            return result
        }

        private fun getParentHasMembersImpl(stub: Stub, result: MutableSet<HasMembersStub>) {
            if (stub is HasMembersStub) {
                result.add(stub as HasMembersStub)
            }
            if (stub.parentStub == null) {
                return
            }
            getParentHasMembersImpl(stub.parentStub, result)
            if (stub.parentStub is DLanguageUnittestStub || stub.parentStub is DLanguageFunctionDeclarationStub || stub.parentStub is DLanguageConstructorStub || stub.parentStub is DLanguageSharedStaticConstructorStub || stub.parentStub is DLanguageStaticConstructorStub || stub.parentStub is DLanguageDestructorStub || stub.parentStub is DLanguageSharedStaticDestructorStub || stub.parentStub is DLanguageStaticDestructorStub) {
                result.clear()
            }
        }
    }
}
