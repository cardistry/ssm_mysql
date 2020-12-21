package Interview10_10;
class   StreamRank {
    int[] a= new int[50010];

    StreamRank() {
        for (int i=1;i<=50001;++i) a[i]=0;
    }

    void track(int x) {
        ++x;
        for (int i=x;i<=50001;i+=i&(-i)) a[i]++;
    }

    int getRankOfNumber(int x) {
        ++x;
        int sum=0;
        for (int i=x;i;i-=i&(-i)) sum+=a[i];
        return sum;
    }
};

