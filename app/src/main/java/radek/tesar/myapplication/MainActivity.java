package radek.tesar.myapplication;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import radek.tesar.myapplication.data.Pyramid;
import radek.tesar.myapplication.data.PyramidGenerator;
import radek.tesar.myapplication.data.impl.RandomPyramidGenerator;
import radek.tesar.myapplication.solver.PyramidSolver;
import radek.tesar.myapplication.solver.impl.NaivePyramidSolver;
import radek.tesar.myapplication.solver.impl.YourSolver;

import static radek.tesar.myapplication.R.layout.activity_main;


public class MainActivity extends AppCompatActivity
{
	TextView mText;
	TextView mControlText;
	TextView mResult;


	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(activity_main);
		mText = (TextView) findViewById(R.id.final_number);
		mControlText = (TextView) findViewById(R.id.control_text);
		mResult = (TextView) findViewById(R.id.result);
		Button mRandom = (Button) findViewById(R.id.random_button);
		Button mMy = (Button) findViewById(R.id.test_button);
		Button mTheir = (Button) findViewById(R.id.their_button);
		Button mControl = (Button) findViewById(R.id.your_control_button);


		mRandom.setOnClickListener(new View.OnClickListener()
		{
			@Override
			public void onClick(View v)
			{
				final PyramidGenerator generator = new RandomPyramidGenerator(5, 99);
				final Pyramid pyramid = generator.generatePyramid();

				System.out.println(pyramid);

				final PyramidSolver solver = new YourSolver();
				mText.setText(String.valueOf(solver.pyramidMaximumTotal(pyramid)));
				result();
			}
		});

		mMy.setOnClickListener(new View.OnClickListener()
		{
			@Override
			public void onClick(View v)
			{
				final PyramidSolver solver = new YourSolver();
				final Pyramid pyramid = new Pyramid(new int[][]{{59, 207, 98, 95}, {87, 1, 70, 0}, {36, 41, 0, 0}, {23, 0, 0, 0},});

				final long total = solver.pyramidMaximumTotal(pyramid);
				mText.setText(String.valueOf(total));
				result();
			}
		});

		mTheir.setOnClickListener(new View.OnClickListener()
		{
			@Override
			public void onClick(View v)
			{
				final PyramidSolver solver = new NaivePyramidSolver();
				final Pyramid pyramid = new Pyramid(new int[][]{{59, 207, 98, 95}, {87, 1, 70, 0}, {36, 41, 0, 0}, {23, 0, 0, 0},});

				final long total = solver.pyramidMaximumTotal(pyramid);
				mText.setText(String.valueOf(total));
				result();
			}
		});

		mControl.setOnClickListener(new View.OnClickListener()
		{
			@Override
			public void onClick(View v)
			{
				//here you can put your control code
				//mControl.setText(String.valueOf(put me here));
				result();
			}
		});


	}


	private void result()
	{
		if(mText.getText().equals(mControlText.getText()))
		{
			mResult.setTextColor(getResources().getColor(R.color.green));
			mResult.setText("Perfectly match");

		}
		else
		{
			mResult.setTextColor(getResources().getColor(R.color.red));
			mResult.setText("Sorry");
		}


	}


	@Override
	public boolean onCreateOptionsMenu(Menu menu)
	{
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.menu_main, menu);
		return true;
	}


	@Override
	public boolean onOptionsItemSelected(MenuItem item)
	{
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();

		//noinspection SimplifiableIfStatement
		if(id==R.id.action_settings)
		{
			return true;
		}

		return super.onOptionsItemSelected(item);
	}
}
