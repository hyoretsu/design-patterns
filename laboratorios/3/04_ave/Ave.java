public class Ave {
    protected String currentLocation;
    protected Integer featherCount;

    public Ave(Integer featherCount) {
        this.featherCount = featherCount;
    }

    public void changeFeathers() {
        this.featherCount -= 1;
    };
}
