package ir.sy.mocha.resources

sealed interface Languages {
    val resources: MochaResources

    data object Persian : Languages {
        override val resources: MochaResources
            get() = PersianResources
    }

    data object English : Languages {
        override val resources: MochaResources
            get() = EnglishResources
    }
}