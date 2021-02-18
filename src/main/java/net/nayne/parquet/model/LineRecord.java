package net.nayne.parquet.model;

public class LineRecord {

    private int policyID;
    private String statecode;
    private String county;
    private float eqSiteLimit;
    private float huSiteLimit;
    private float flSiteLimit;
    private float frSiteLimit;
    private float tiv2011;
    private float tiv2012;
    private float eqSiteDeductible;
    private float huSiteDeductible;
    private float flSiteDeductible;
    private float frSiteDeductible;
    private float pointLatitude;
    private float pointLongitude;
    private String line;
    private String construction;
    private int pointGranularity;

    public int getPolicyID() {
        return policyID;
    }

    public void setPolicyID(int policyID) {
        this.policyID = policyID;
    }

    public String getStatecode() {
        return statecode;
    }

    public void setStatecode(String statecode) {
        this.statecode = statecode;
    }

    public String getCounty() {
        return county;
    }

    public void setCounty(String county) {
        this.county = county;
    }

    public float getEqSiteLimit() {
        return eqSiteLimit;
    }

    public void setEqSiteLimit(float eqSiteLimit) {
        this.eqSiteLimit = eqSiteLimit;
    }

    public float getHuSiteLimit() {
        return huSiteLimit;
    }

    public void setHuSiteLimit(float huSiteLimit) {
        this.huSiteLimit = huSiteLimit;
    }

    public float getFlSiteLimit() {
        return flSiteLimit;
    }

    public void setFlSiteLimit(float flSiteLimit) {
        this.flSiteLimit = flSiteLimit;
    }

    public float getFrSiteLimit() {
        return frSiteLimit;
    }

    public void setFrSiteLimit(float frSiteLimit) {
        this.frSiteLimit = frSiteLimit;
    }

    public float getTiv2011() {
        return tiv2011;
    }

    public void setTiv2011(float tiv2011) {
        this.tiv2011 = tiv2011;
    }

    public float getTiv2012() {
        return tiv2012;
    }

    public void setTiv2012(float tiv2012) {
        this.tiv2012 = tiv2012;
    }

    public float getEqSiteDeductible() {
        return eqSiteDeductible;
    }

    public void setEqSiteDeductible(float eqSiteDeductible) {
        this.eqSiteDeductible = eqSiteDeductible;
    }

    public float getHuSiteDeductible() {
        return huSiteDeductible;
    }

    public void setHuSiteDeductible(float huSiteDeductible) {
        this.huSiteDeductible = huSiteDeductible;
    }

    public float getFlSiteDeductible() {
        return flSiteDeductible;
    }

    public void setFlSiteDeductible(float flSiteDeductible) {
        this.flSiteDeductible = flSiteDeductible;
    }

    public float getFrSiteDeductible() {
        return frSiteDeductible;
    }

    public void setFrSiteDeductible(float frSiteDeductible) {
        this.frSiteDeductible = frSiteDeductible;
    }

    public float getPointLatitude() {
        return pointLatitude;
    }

    public void setPointLatitude(float pointLatitude) {
        this.pointLatitude = pointLatitude;
    }

    public float getPointLongitude() {
        return pointLongitude;
    }

    public void setPointLongitude(float pointLongitude) {
        this.pointLongitude = pointLongitude;
    }

    public String getLine() {
        return line;
    }

    public void setLine(String line) {
        this.line = line;
    }

    public String getConstruction() {
        return construction;
    }

    public void setConstruction(String construction) {
        this.construction = construction;
    }

    public int getPointGranularity() {
        return pointGranularity;
    }

    public void setPointGranularity(int pointGranularity) {
        this.pointGranularity = pointGranularity;
    }
}
