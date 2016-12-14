

public ArrayList<int[]> mergeSort(ArrayList<int[]> r){
  ArrayList<int[]> left = new ArrayList<int[]>();
  ArrayList<int[]> right = new ArrayList<int[]>();
  int center;

  if(r.size() == 1){
    return r;
  }
  else{
    center = r.size()/2;
    for(int i = 0; i < center; i++){
      left.add(r.get(i));
    }
    for(int i = center; i < r.size(); i++){
      right.add(r.get(i));
    }

    left = mergeSort(left);
    right = mergeSort(right);

    r =merge(left,right,r);
  }

  return r;
}

public ArrayList<int[]> merge(ArrayList<int[]> left, ArrayList<int[]> right, ArrayList<int[]> whole){
  int lIndex = 0;
  int rIndex = 0;
  int wIndex = 0;
  while(lIndex < left.size() && rIndex < right.size()){
    int[] tempLeft = left.get(lIndex);
    int[] tempRight = right.get(rIndex);
    if(tempLeft[1] < tempRight[1]){
      whole.set(wIndex,left.get(lIndex));
      lIndex++;
    }
    else{
      whole.set(wIndex,right.get(rIndex));
      rIndex++;
    }
    wIndex++;
  }
  ArrayList<int[]> rest;
  int reIndex;
  if(lIndex >= left.size()){
    rest = right;
    reIndex = rIndex;
  }
  else{
    rest = left;
    reIndex = lIndex;
  }
  for(int i = reIndex; i <rest.size(); i++){
    whole.set(wIndex,rest.get(i));
    wIndex++;
  }
  return whole;
}
