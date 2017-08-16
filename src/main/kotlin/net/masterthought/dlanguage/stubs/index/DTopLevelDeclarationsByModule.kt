package net.masterthought.dlanguage.stubs.index

import com.intellij.openapi.project.Project
import com.intellij.psi.search.GlobalSearchScope
import com.intellij.psi.stubs.*
import net.masterthought.dlanguage.psi.DLanguageFile
import net.masterthought.dlanguage.psi.DLanguageSingleImport
import net.masterthought.dlanguage.psi.interfaces.DNamedElement
import net.masterthought.dlanguage.psi.interfaces.HasMembers
import net.masterthought.dlanguage.stubs.DLanguageIdentifierStub
import net.masterthought.dlanguage.stubs.index.DTopLevelDeclarationIndex.Companion.getTopLevelSymbols

/**
 * Created by francis on 6/17/2017.
 */
class DTopLevelDeclarationsByModule : StringStubIndexExtension<DNamedElement>() {
    override fun getKey(): StubIndexKey<String, DNamedElement> {
        return KEY
    }

    override fun getVersion(): Int {
        return VERSION
    }

    companion object {
        val KEY: StubIndexKey<String, DNamedElement> = StubIndexKey.createIndexKey<String, DNamedElement>("d.globally.accessible.module")
        val VERSION = 2
        fun <S : NamedStubBase<T>, T : DNamedElement> indexTopLevelDeclarationsByModule(stub: S, sink: IndexSink) {
            if (stub !is DLanguageIdentifierStub && topLevelDeclaration(stub)) {
                val fileName = (stub.psi.containingFile as DLanguageFile).moduleOrFileName
                sink.occurrence(DTopLevelDeclarationsByModule.KEY, fileName)
            }
        }

        //todo better name/stop repeating type signature?
        fun getSymbolsFromImport(import: DLanguageSingleImport): MutableSet<DNamedElement> {
            if (import.applicableImportBinds.size == 0) {
                return StubIndex.getElements(KEY, import.importedModuleName, import.project, GlobalSearchScope.everythingScope(import.project), DNamedElement::class.java).toMutableSet()
            }
            val symbols = mutableSetOf<DNamedElement>()
            for (bind in import.applicableImportBinds) {
                for (resolvedBind in getTopLevelSymbols(bind, import.importedModuleName, import.project)) {
                    symbols.add(resolvedBind)
                    if (resolvedBind is HasMembers<*>) {
                        symbols.addAll(resolvedBind.members.map { it.psi as DNamedElement })
                    }
                }
            }
            return symbols
        }
    }
}


class DTopLevelDeclarationsByModuleAndName : StringStubIndexExtension<DNamedElement>() {
    override fun getKey(): StubIndexKey<String, DNamedElement> {
        return KEY
    }

    override fun getVersion(): Int {
        return VERSION
    }

    companion object {
        val KEY: StubIndexKey<String, DNamedElement> = StubIndexKey.createIndexKey<String, DNamedElement>("d.globally.accessible.module.name")
        val VERSION = 2
        fun <S : NamedStubBase<T>, T : DNamedElement> indexTopLevelDeclarationsByModule(stub: S, sink: IndexSink) {
            if (stub !is DLanguageIdentifierStub && topLevelDeclaration(stub)) {
                val moduleName = (stub.psi.containingFile as DLanguageFile).moduleOrFileName
                val name = stub.name
                sink.occurrence(DTopLevelDeclarationsByModule.KEY, toKey(moduleName, name))//the backslash is used as a separator so that strange names + moduleNames don't cause bugs
            }
        }

        private fun toKey(moduleName: String, name: String?) = moduleName + "\\" + name

        fun getSymbol(name: String, moduleName: String, project: Project): MutableCollection<DNamedElement> {
            return StubIndex.getElements(KEY, toKey(moduleName, name), project, GlobalSearchScope.everythingScope(project), DNamedElement::class.java)
        }
    }
}
