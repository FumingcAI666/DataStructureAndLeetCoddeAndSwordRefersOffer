package naixue;

/**
 * @author macfmc
 * @date 2020/10/31-12:39
 */
public class Box<U> {
    U u;

    public U get() {
        return u;
    }

    public void set(U u) {
        this.u = u;
    }
}
