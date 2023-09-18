class ProductOfNumbers {
    List<Integer> a;
    public ProductOfNumbers() {
        a = new ArrayList<>();
        a.add(1);
    }
    
    public void add(int num) {
        if(num == 0) {
            a = new ArrayList<>();
            a.add(1);
        }
        else {
            a.add(a.get(a.size() - 1) * num);
        }
    }
    
    public int getProduct(int k) {
        return k < a.size() ? a.get(a.size() - 1) / a.get(a.size() - k - 1) : 0;
    }
}

/**
 * Your ProductOfNumbers object will be instantiated and called as such:
 * ProductOfNumbers obj = new ProductOfNumbers();
 * obj.add(num);
 * int param_2 = obj.getProduct(k);
 */