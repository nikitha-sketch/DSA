class Robot {
    int width, height;
    int x, y;
    int dir; // 0=East, 1=North, 2=West, 3=South
    int perimeter;
    int steps;

    public Robot(int width, int height) {
        this.width = width;
        this.height = height;
        this.x = 0;
        this.y = 0;
        this.dir = 0;
        this.perimeter = 2 * (width - 1) + 2 * (height - 1);
        this.steps = 0;
    }

    public void step(int num) {
        steps = (steps + num) % perimeter;

        // special case: if at origin and completed full loop
        if (steps == 0) {
            x = 0;
            y = 0;
            dir = 3; // South
            return;
        }

        int s = steps;

        if (s <= width - 1) {
            x = s;
            y = 0;
            dir = 0; // East
        } 
        else if (s <= (width - 1) + (height - 1)) {
            x = width - 1;
            y = s - (width - 1);
            dir = 1; // North
        } 
        else if (s <= 2 * (width - 1) + (height - 1)) {
            x = width - 1 - (s - ((width - 1) + (height - 1)));
            y = height - 1;
            dir = 2; // West
        } 
        else {
            x = 0;
            y = height - 1 - (s - (2 * (width - 1) + (height - 1)));
            dir = 3; // South
        }
    }

    public int[] getPos() {
        return new int[]{x, y};
    }

    public String getDir() {
        String[] dirs = {"East", "North", "West", "South"};
        return dirs[dir];
    }
}