package vn.co.cex.bean;

import java.io.Serializable;
import java.util.List;

import org.primefaces.model.chart.Axis;
import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.BarChartModel;
import org.primefaces.model.chart.ChartSeries;
import org.primefaces.model.chart.LineChartModel;
import org.primefaces.model.chart.LineChartSeries;

import vn.co.cex.bo.BillOfLadingBO;
import vn.co.cex.dto.ChartViewDTO;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;

@ManagedBean(name = "chartView", eager = true)
public class ChartView extends BaseBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6249680320537323973L;

	@ManagedProperty(value = "#{billOfLadingBO}")
	private BillOfLadingBO billOfLadingBO;

	private List<ChartViewDTO> charViewList;
	private int maxBillOfLading;
	private float maxValue;

	private LineChartModel animatedModel1;
	private BarChartModel animatedModel2;

	public BillOfLadingBO getBillOfLadingBO() {
		return billOfLadingBO;
	}

	public void setBillOfLadingBO(BillOfLadingBO billOfLadingBO) {
		this.billOfLadingBO = billOfLadingBO;
	}

	public List<ChartViewDTO> getCharViewList() {
		return charViewList;
	}

	public void setCharViewList(List<ChartViewDTO> charViewList) {
		this.charViewList = charViewList;
	}

	public int getMaxBillOfLading() {
		return maxBillOfLading;
	}

	public void setMaxBillOfLading(int maxBillOfLading) {
		this.maxBillOfLading = maxBillOfLading;
	}

	public float getMaxValue() {
		return maxValue;
	}

	public void setMaxValue(float maxValue) {
		this.maxValue = maxValue;
	}

	@PostConstruct
	public void init() {
		try {
			charViewList = billOfLadingBO.getChartView();

			if (charViewList == null) {
				return;
			}

			for (ChartViewDTO chartViewDTO : charViewList) {
				if (maxBillOfLading < chartViewDTO.getTotalBillOfLading()) {
					maxBillOfLading = chartViewDTO.getTotalBillOfLading();
				}
				if (maxValue < chartViewDTO.getTotalValue()) {
					maxValue = chartViewDTO.getTotalValue();
				}
			}
			createAnimatedModels();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public LineChartModel getAnimatedModel1() {
		return animatedModel1;
	}

	public BarChartModel getAnimatedModel2() {
		return animatedModel2;
	}

	private void createAnimatedModels() {
		animatedModel1 = initLinearModel();
		animatedModel1.setTitle("Biểu đồ Vận đơn");
		animatedModel1.setAnimate(true);
		animatedModel1.setLegendPosition("se");
		Axis yAxis = animatedModel1.getAxis(AxisType.Y);
		yAxis.setMin(1);
		yAxis.setMax(maxBillOfLading * 2);

		Axis xAis = animatedModel1.getAxis(AxisType.X);
		xAis.setMin(0);
		xAis.setMax(12);

		animatedModel2 = initBarModel();
		animatedModel2.setTitle("Biểu đồ giá trị");
		animatedModel2.setAnimate(true);
		animatedModel2.setLegendPosition("ne");
		yAxis = animatedModel2.getAxis(AxisType.Y);
		yAxis.setMin(0);
		yAxis.setMax(maxValue * 2);
	}

	private BarChartModel initBarModel() {
		BarChartModel model = new BarChartModel();

		ChartSeries value = new ChartSeries();
		value.setLabel("VND");
		for (int i = 0; i < charViewList.size(); i++) {
			value.set(charViewList.get(i).getMonth(), charViewList.get(i).getTotalValue());
		}

		model.addSeries(value);

		return model;
	}

	private LineChartModel initLinearModel() {
		LineChartModel model = new LineChartModel();

		LineChartSeries series1 = new LineChartSeries();
		series1.setLabel("Thành công");

		LineChartSeries series2 = new LineChartSeries();
		series2.setLabel("Thất bại");

		for (ChartViewDTO chartViewDTO : charViewList) {
			series1.set(chartViewDTO.getMonth(), chartViewDTO.getBillOfLadingSucceeded());
			series2.set(chartViewDTO.getMonth(), chartViewDTO.getBillOfLadingFailed());
		}

		model.addSeries(series1);
		model.addSeries(series2);

		return model;
	}
}
