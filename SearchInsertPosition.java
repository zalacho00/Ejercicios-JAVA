public class SearchInsertPosition {
    public static void main(String[] args) {
        int target = 7;
        int[] nums = {1,3,5,6};
        boolean encontrado = true;
        
        for(int i = 0; i < nums.length; i++){
            if(target - nums[i] == 0){
                System.out.println(i);
                encontrado = true;
                break;
            }else{
                encontrado = false;
            }
        }
        if(encontrado == false){
            for(int i = 0; i < nums.length; i++){
                if(target - nums[i] < 0){
                    System.out.println(i);
                    encontrado = true;
                    break;
                }
            }
        }
    }
}
