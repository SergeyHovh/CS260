# CS260

Final Project for AUA CS260 - Image Processing Class

### Stage 1

Applying blur and binary layer filters to obtain different facial parts.

After some experiments, the main "blur" filter was chosen to be

1 | 1 | 1 | 1 | 1
--- | --- | --- | --- | ---
1 | 1 | 1 | 1 | 1
1 | 1 | 0 | 1 | 1
1 | 1 | 1 | 1 | 1
1 | 1 | 1 | 1 | 1

After applying this filter, the other 4 binary filters were applied 
to each picture. The results may be found in the corresponding directory.

The Kernel may also be found as a .txt file in the same directory.

### Stage 2

For this stage the cropped pictures were used (see **Stage2/data**)

The results may be found in an Excel file - **results.xlsx** : 
each column represents one chanel of colour for each picture.
The cells are filled respectively to their value,
 such that each column is the histogram itself.
 
 ### Stage 3
 As we can observe here, the 3rd binary filter leaves only ear(s) and mouth. 
 Thus we can cluster the picture into smaller rectangles and compute the **moment** for it. 
 If we obtain horizontal part of a face, we may conclude, that we are dealing with a mouth. 
 If the part is vertical - ear(s)  
  
 ![alt text](https://github.com/SergeyHovh/CS260/blob/master/src/com/company/Stage1/results/68-11-3.jpg?raw=true)