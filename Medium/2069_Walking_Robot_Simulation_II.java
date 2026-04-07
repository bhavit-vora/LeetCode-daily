/*
    TC: O(n)
    SC: O(1)
*/

class Robot {

    int x, y, perimeter;
    int height, width, dir;

    public Robot(int width, int height) {
        this.x = 1;
        this.y = 1;
        this.dir = 0;
        this.height = height;
        this.width = width;
        perimeter = 2 * height + 2 * (width - 2);
    }
    
    public void step(int num) {
        if(num == 0) return;

        num %= perimeter;
        if(num == 0) num = perimeter;
        if(dir == 0) {
            int rem = width - x;
            x += Math.min(num, rem);
            num -= Math.min(num, rem);
            if(num > 0) {
                dir = (dir + 1) % 4;
                step(num);
            }
        } else if(dir == 1) {
            int rem = height - y;
            y += Math.min(num, rem);
            num -= Math.min(num, rem);
            if(num > 0) {
                dir = (dir + 1) % 4;
                step(num);
            }
        } else if(dir == 2) {
            int rem = x - 1;
            x -= Math.min(num, rem);
            num -= Math.min(num, rem);
            if(num > 0) {
                dir = (dir + 1) % 4;
                step(num);
            }
        } else if(dir == 3) {
            int rem = y - 1;
            y -= Math.min(num, rem);
            num -= Math.min(num, rem);
            if(num > 0) {
                dir = (dir + 1) % 4;
                step(num);
            }
        }
    }
    
    public int[] getPos() {
        return new int[]{x-1, y-1};
    }
    
    public String getDir() {
        if(dir == 0) return "East";
        if(dir == 1) return "North";
        if(dir == 2) return "West";
        return "South";
    }
}

/**
 * Your Robot object will be instantiated and called as such:
 * Robot obj = new Robot(width, height);
 * obj.step(num);
 * int[] param_2 = obj.getPos();
 * String param_3 = obj.getDir();
 */