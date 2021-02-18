package net.nayne.parquet.worker;

import net.nayne.parquet.model.LineRecord;

public class LineParser {

    public static LineRecord parse(String[] rawLine) {
        LineRecord lineRecord = new LineRecord();
        int position = 0;
        lineRecord.setPolicyID(Integer.parseInt(rawLine[position++]));
        lineRecord.setStatecode(rawLine[position++]);
        lineRecord.setCounty(rawLine[position++]);
        lineRecord.setEqSiteLimit(Float.parseFloat(rawLine[position++]));
        lineRecord.setHuSiteLimit(Float.parseFloat(rawLine[position++]));
        lineRecord.setFlSiteLimit(Float.parseFloat(rawLine[position++]));
        lineRecord.setFrSiteLimit(Float.parseFloat(rawLine[position++]));
        lineRecord.setTiv2011(Float.parseFloat(rawLine[position++]));
        lineRecord.setTiv2012(Float.parseFloat(rawLine[position++]));
        lineRecord.setEqSiteDeductible(Float.parseFloat(rawLine[position++]));
        lineRecord.setHuSiteDeductible(Float.parseFloat(rawLine[position++]));
        lineRecord.setFlSiteDeductible(Float.parseFloat(rawLine[position++]));
        lineRecord.setFrSiteDeductible(Float.parseFloat(rawLine[position++]));
        lineRecord.setPointLatitude(Float.parseFloat(rawLine[position++]));
        lineRecord.setPointLatitude(Float.parseFloat(rawLine[position++]));
        lineRecord.setLine(rawLine[position++]);
        lineRecord.setConstruction(rawLine[position++]);
        lineRecord.setPointGranularity(Integer.parseInt(rawLine[position++]));
        return lineRecord;
    }

}
