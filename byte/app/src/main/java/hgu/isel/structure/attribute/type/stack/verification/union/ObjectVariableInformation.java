package hgu.isel.structure.attribute.type.stack.verification.union;

import hgu.isel.structure.attribute.type.stack.verification.VerificationTypeInformation;

public class ObjectVariableInformation implements VerificationTypeInformation {
    private final byte tag = 7;
    private byte[] constantPoolIndex; // u2
}
