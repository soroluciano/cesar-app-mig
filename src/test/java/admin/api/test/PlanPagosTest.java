package admin.api.test;


import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;

import admin.api.model.FeeStatus;
import admin.api.model.PayPlan;
import admin.api.model.PayPlanFee;
public class PlanPagosTest {

	private static Logger logger = org.slf4j.LoggerFactory.getLogger(PlanPagosTest.class);
	private static PayPlan payPlan;
	private static PayPlan payPlanPagoTotal;
	

	@BeforeAll
	static void crearPlan() {
		BigDecimal montoTotalProductos = new BigDecimal("9000.00");
		BigDecimal cantidadCuotas = new BigDecimal("6.00");
		logger.info("Creando plan de pagos");
		logger.info("Monto total factura:" + montoTotalProductos);
		BigDecimal montoCuota = dividirCuotas(montoTotalProductos, cantidadCuotas);

		payPlan = new PayPlan();
		LocalDate diaDeCreacion = LocalDate.now();
		payPlan.setStartDate(diaDeCreacion);

		List<PayPlanFee> payPlanFeeList = crearCuotas(montoCuota, cantidadCuotas);
		payPlan.setPayPlanFeeList(payPlanFeeList);

	}

	@Test
	public void pagarAnticipo() {

		pagarCuotaPorFechaActual(payPlan);

	}
	

	private void pagarCuotaPorFechaActual(PayPlan payPlan2) {

		List<PayPlanFee> payPlanFeeList = payPlan2.getPayPlanFeeList();
		PayPlanFee payPlanFee = payPlanFeeList.get(0);
		logger.info("payPlanFee 0:"+payPlanFee);
	
	}

	
	private void pagarCuotaBySequence(PayPlan payPlan2, Integer sequence) {
		
		
		
		
	}

	@Test
	public void pagarDosCuotas() {
		
	}
	
	@Test
	public void pagarTodo() {
		
	}
	
	
    private static List<PayPlanFee> crearCuotas(BigDecimal montoCuota, BigDecimal cantidadCuotas) {
    	
    	@SuppressWarnings("deprecation")
		Integer feeSize = new Integer(cantidadCuotas.intValue());
    	List<PayPlanFee> resultList = new ArrayList<PayPlanFee>();
    	
    	LocalDate diaDeCreacion = LocalDate.now();
    	Month month = diaDeCreacion.getMonth();
		LocalDate lastDateToPay =  LocalDate.of(diaDeCreacion.getYear(), month, 7);
    	
    	for(int i = 0; i< feeSize; i++) {
    		PayPlanFee fee = new PayPlanFee();
    		if(i == 0) {
    			logger.info("Dia de pago:"+lastDateToPay);
        		fee.setDateToPay(lastDateToPay);
    		}else {
    			LocalDate nextDate = getNextDate(lastDateToPay);
    			logger.info("Dia de pago:"+nextDate);
        		fee.setDateToPay(nextDate);
        		lastDateToPay = nextDate;
    		}
    		logger.info("cuota numero:"+i);
    		fee.setMoneyFee(montoCuota);
    		fee.setSequence(i);
    		logger.info("Fee status:"+FeeStatus.INITIAL);
    		fee.setStatus(FeeStatus.INITIAL);
    	}
		return resultList;
   }


    public static LocalDate getNextDate(LocalDate date) {
    	LocalDate plusMonths = date.plusMonths(1);
    	return  plusMonths;
		
    }
    
	public static BigDecimal dividirCuotas(BigDecimal monto, BigDecimal cantidadCuotas) {
        BigDecimal cuota = monto.divide(cantidadCuotas);
        logger.info("cuota:"+cuota);
        return cuota;
    }
 
    @Test
    public void test2() {
        
    }
}
