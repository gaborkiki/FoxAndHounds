package hu.krisz.foxandhounds.model;

public class GState {
    private MapVO mapVO;
    private boolean mapExist;
    private boolean shouldExit;
    private int[] fox;
    private int[][] hounds;

    public GState(MapVO mapVO, boolean mapExist, boolean shouldExit, int[] fox, int[][] hounds) {
        this.mapVO = mapVO;
        this.mapExist = mapExist;
        this.shouldExit = shouldExit;
        this.fox = fox;
        this.hounds = hounds;
    }

    public MapVO getMapVO() {
        return mapVO;
    }

    public void setMapVO(MapVO mapVO) {
        this.mapVO = mapVO;
    }

    public boolean isMapExist() {
        return mapExist;
    }

    public void setMapExist(boolean mapExist) {
        this.mapExist = mapExist;
    }

    public boolean isShouldExit() {
        return shouldExit;
    }

    public void setShouldExit(boolean shouldExit) {
        this.shouldExit = shouldExit;
    }

    public int[] getFox() {
        return fox;
    }

    public void setFox(int[] fox) {
        this.fox = fox;
    }

    public int[][] getHounds() {
        return hounds;
    }

    public void setHounds(int[][] hounds) {
        this.hounds = hounds;
    }
}
