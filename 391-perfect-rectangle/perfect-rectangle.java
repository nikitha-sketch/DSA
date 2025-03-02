class Solution {
    public boolean isRectangleCover(int[][] rectangles) {
        int minX=Integer.MAX_VALUE,minY=Integer.MAX_VALUE;
        int maxX=Integer.MIN_VALUE,maxY=Integer.MIN_VALUE;
        int totalArea=0;
        Set<String>corners=new HashSet<>();
        for(int rect[]:rectangles){
            int x1=rect[0],y1=rect[1];
            int x2=rect[2],y2=rect[3];
            minX=Math.min(minX,x1);
            minY=Math.min(minY,y1);
            maxX=Math.max(maxX,x2);
            maxY=Math.max(maxY,y2);
            totalArea+=(x2-x1)*(y2-y1);
            String points[]={x1+","+y1,x1+","+y2,x2+","+y1,x2+","+y2};
            for(String point:points){
                if(!corners.add(point)){
                    corners.remove(point);
                }
            }
        }
        int expectedArea=(minX-maxX)*(minY-maxY);
        if(totalArea!=expectedArea)return false;
        return corners.size()==4 &&
            corners.contains(minX+","+minY)&&
            corners.contains(minX+","+maxY)&&
            corners.contains(maxX+","+minY)&&
            corners.contains(maxX+","+maxY);
            
    }
}