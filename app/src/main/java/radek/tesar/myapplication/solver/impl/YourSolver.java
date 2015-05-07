package radek.tesar.myapplication.solver.impl;


import android.util.Log;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import radek.tesar.myapplication.data.Pyramid;
import radek.tesar.myapplication.solver.PyramidSolver;


/**
 * TASK: This is your 2nd task.
 * Please implement the class to satisfy the interface. *
 */
public class YourSolver implements PyramidSolver

{

	int[][] ahoj;


	@Override
	public long pyramidMaximumTotal(Pyramid pyramid)
	{

		makeInverteIntArray(pyramid);
		return getTotalAbove(pyramid.getRows() - 1, 0, pyramid);
	}


	private int[][] makeInverteIntArray(Pyramid pyramid)
	{
		ahoj = new int[pyramid.getRows()][pyramid.getColomn()];
		for(int r = 0; r<pyramid.getRows(); r++)
		{
			for(int c = 0; c<pyramid.getColomn(); c++)
			{
				if(pyramid.get(r, c) == 0)
				{
					ahoj[r][c] = 0;
				}else{
					ahoj[r][c] = pyramid.get(r, c);
				}

			}

		}

		return ahoj;
	}


	private long getTotalAbove(int row, int column, Pyramid pyramid)
	{

		for(int r = ahoj.length - 1; r>0; r--)
		{


			for(int c = 0; c<ahoj[r].length - 1; c++)
			{
				if(c==0)
				{
					ahoj[r - 1][c] += ahoj[r][c];
				}else{
					ahoj[r - 1][c] += Math.max(ahoj[r][c], ahoj[r][c - 1]);
				}

			}
		}
		System.out.println(String.valueOf(ahoj));
		Log.d("Tisk",String.valueOf(ahoj));
		System.out.println(pyramid);
		int max = 0;
		for(int i = 0; i<ahoj[0].length;i++)
		{
			if(ahoj[0][i] > max){
				max = ahoj[0][i];
			}
		}



		return max;
	}


}
