package hgu.isel.structure.attribute.type;

import hgu.isel.structure.attribute.AttributeInformation;
import hgu.isel.structure.attribute.type.module.Exports;
import hgu.isel.structure.attribute.type.module.Opens;
import hgu.isel.structure.attribute.type.module.Provides;
import hgu.isel.structure.attribute.type.module.Requires;
import hgu.isel.structure.attribute.type.module.uses.UsesIndex;

public class Module implements AttributeInformation {
    private byte[] attributeNameIndex; // u2
    private byte[] attributeLength; // u4
    private byte[] moduleNameIndex; // u2
    private byte[] moduleFlags; // u2
    private byte[] moduleVersionIndex; // u2
    private byte[] requiresCount; // u2
    private Requires[] requires; // requiresCount
    private byte[] exportsCount; // u2
    private Exports[] exports; // exportsCount
    private byte[] opensCount; // u2
    private Opens[] opens; // opensCount
    private byte[] usesCount; // u2
    private UsesIndex[] usesIndex; // usesCount
    private byte[] providesCount; // u2
    private Provides[] provides; // providesCount
}
