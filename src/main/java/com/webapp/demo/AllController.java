package com.webapp.demo;


import java.security.PublicKey; 
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.webapp.demo.Component.BarcodeScanner;
import com.webapp.demo.Component.Inventory;
import com.webapp.demo.Component.Location;
import com.webapp.demo.Component.Product;
import com.webapp.demo.Component.PurchaseOrder;
import com.webapp.demo.Component.Sale;
import com.webapp.demo.Component.Shipment;
import com.webapp.demo.Repository.Barcodescannerdao;
import com.webapp.demo.Repository.Inventorydao;
import com.webapp.demo.Repository.Locationdao;
import com.webapp.demo.Repository.Productdao;
import com.webapp.demo.Repository.Purchaseorderdao;
import com.webapp.demo.Repository.Saledao;
import com.webapp.demo.Repository.Shipmentdao;

@Controller
public class AllController {

@Autowired	
Barcodescannerdao barcode;

@Autowired
Inventorydao inventorydao;

@Autowired
Locationdao location;

@Autowired
Productdao product;

@Autowired
Purchaseorderdao purchase;

@Autowired
Saledao sale;

@Autowired
Shipmentdao shipment;



@PostMapping("/product")
public void product( @RequestBody Product p) {
	product.save(p);
}



@ResponseBody
@GetMapping("/product")
public List<Product> getpro(){
 return product.findAll();
}


@PutMapping("/product")
public void putpro(@RequestBody Product p) {
	product.save(p);
}


@DeleteMapping("/product")
public void detpro() {
	product.deleteAll();
}

@PostMapping("/inventory")
public void inventory(@RequestBody Inventory i) {
    Product p2=product.findById(i.getProduct().getId()).orElse(null);
    i.setProduct(p2);
	inventorydao.save(i);
}

@ResponseBody
@GetMapping("/inventory")
public List<Inventory> gettub(){
	List<Inventory> optional=inventorydao.findAll();
	return optional;
}



@PutMapping("/inventory")
public void putinv(@RequestBody Inventory i) {
	Product p2=product.findById(i.getProduct().getId()).orElse(null);
    i.setProduct(p2);
	inventorydao.save(i);
}


@DeleteMapping("/inventory")
public void delinv(int id) {
	inventorydao.deleteById(id);
}

@PostMapping("/purchase-order")
public void purchase(@RequestBody PurchaseOrder p) {
	Product p2=product.findById(p.getProductId()).orElse(null);
	p2.setQuantity(p2.getQuantity()+p.getQuantity());
	purchase.save(p);
	
	product.save(p2);
}
@ResponseBody
@GetMapping("/purchase-order")
public List<PurchaseOrder> pur(){
	return purchase.findAll();
}

@PutMapping("purchase-order")
public void putpurchase(@RequestBody PurchaseOrder p) {
	Product p2=product.findById(p.getProductId()).orElse(null);
	PurchaseOrder original=purchase.findById(p.getId()).orElse(null);
	p2.setQuantity(p2.getQuantity()-original.getQuantity()+p.getQuantity());
	purchase.save(p);
	product.save(p2);
}

@DeleteMapping("purchase-order")
public void delpur(int id) {
	purchase.deleteById(id);
}


@PostMapping("/sales")
public void setsal(@RequestBody Sale s) {
	
	sale.save(s);
	
}

@ResponseBody
@GetMapping("/sales")
public List<Sale> getsal(){
	return sale.findAll();
}

@PutMapping("/sales")
public void putsal(@RequestBody Sale s) {
	sale.save(s);
}

@DeleteMapping("/sales")
public void delsal(int id) {
	sale.deleteById(id);
}

@PostMapping("/shipment")
public void setship(@RequestBody Shipment sh) {
	Product p2=product.findById(sh.getProductId()).orElse(null);
	p2.setQuantity(p2.getQuantity()-sh.getQuantity());
	shipment.save(sh);
	product.save(p2);
}
@ResponseBody
@GetMapping("/shipment")
public List<Shipment> getship(){
	return shipment.findAll();
}

@PutMapping("/shipment")
public void putship(@RequestBody Shipment sh) {
	Shipment originalShipment=shipment.findById(sh.getId()).orElse(null);
	Product p2=product.findById(sh.getProductId()).orElse(null);
	p2.setQuantity(p2.getQuantity()+originalShipment.getQuantity()-sh.getQuantity());
	shipment.save(sh);
	product.save(p2);
}

@DeleteMapping("/shipment")
public void delship(int id) {
	shipment.deleteById(id);
}

@PostMapping("/locations")
public void setloc(@RequestBody Location l) {
	location.save(l);
}
@ResponseBody
@GetMapping("/locations")
public List<Location> getloc(){
	return location.findAll();
}

@PutMapping("/locations")
public void putloc(@RequestBody Location l) {
	location.save(l);
}

@DeleteMapping("/locations")
public void delloc(int id) {
	location.deleteById(id);
}

@PostMapping("/barcode-scanners")
public void setbar(@RequestBody BarcodeScanner b) {
	barcode.save(b);
}

@ResponseBody
@GetMapping("/barcode-scanners")
public List<BarcodeScanner> getbar(){
	return barcode.findAll();
}

@PutMapping("/barcode-scanners")
public void putbar(@RequestBody BarcodeScanner b) {
	barcode.save(b);
}

@DeleteMapping("/barcode-scanners")
public void delbar(int id) {
	barcode.deleteById(id);
}

}