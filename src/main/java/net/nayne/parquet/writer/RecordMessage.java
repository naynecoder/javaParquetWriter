package net.nayne.parquet.writer;


import org.apache.parquet.schema.MessageType;
import org.apache.parquet.schema.PrimitiveType;
import org.apache.parquet.schema.PrimitiveType.PrimitiveTypeName;
import org.apache.parquet.schema.Type.Repetition;

public class RecordMessage {

    private RecordMessage() {
    }

    public static MessageType getSchema() {
        return new MessageType("RecordSchema",
            new PrimitiveType(Repetition.REQUIRED, PrimitiveTypeName.INT32, "PolicyId"),
            new PrimitiveType(Repetition.REQUIRED, PrimitiveTypeName.BINARY, "StateCode"),
            new PrimitiveType(Repetition.REQUIRED, PrimitiveTypeName.BINARY, "County"),
            new PrimitiveType(Repetition.REQUIRED, PrimitiveTypeName.FLOAT, "EqSiteLimit"),
            new PrimitiveType(Repetition.REQUIRED, PrimitiveTypeName.FLOAT, "HuSiteLimit"),
            new PrimitiveType(Repetition.REQUIRED, PrimitiveTypeName.FLOAT, "FlSiteLimit"),
            new PrimitiveType(Repetition.REQUIRED, PrimitiveTypeName.FLOAT, "FrSiteLimit"),
            new PrimitiveType(Repetition.REQUIRED, PrimitiveTypeName.FLOAT, "Tiv2011"),
            new PrimitiveType(Repetition.REQUIRED, PrimitiveTypeName.FLOAT, "Tiv2012"),
            new PrimitiveType(Repetition.REQUIRED, PrimitiveTypeName.FLOAT, "EqSiteDeductible"),
            new PrimitiveType(Repetition.REQUIRED, PrimitiveTypeName.FLOAT, "HuSiteDeductible"),
            new PrimitiveType(Repetition.REQUIRED, PrimitiveTypeName.FLOAT, "FlSiteDeductible"),
            new PrimitiveType(Repetition.REQUIRED, PrimitiveTypeName.FLOAT, "FrSiteDeductible"),
            new PrimitiveType(Repetition.REQUIRED, PrimitiveTypeName.FLOAT, "PointLatitude"),
            new PrimitiveType(Repetition.REQUIRED, PrimitiveTypeName.FLOAT, "PointLongitude"),
            new PrimitiveType(Repetition.REQUIRED, PrimitiveTypeName.BINARY, "Line"),
            new PrimitiveType(Repetition.REQUIRED, PrimitiveTypeName.BINARY, "Construction"),
            new PrimitiveType(Repetition.REQUIRED, PrimitiveTypeName.INT32, "PointGranularity"));
    }

}
