package com.sohu.business.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.sohu.business.model.pojo.AccountPassport;
import com.sohu.business.service.impl.AccountPassportService;
/**
 * @author chengchengbj8545
 *通行证相关管理
 */

@Controller
public class AccountPassportController {
	
	@Autowired
	private AccountPassportService accountPassportService;
	
	/**
	 * 通行证相关管理(查询)
	 * @param passport(搜狐通行证，参数非必须)
	 */
	
	@RequestMapping("passport!search.action")
	public ModelAndView selectPassport(
			@RequestParam(value = "passport", required = false) String  passport,
			HttpServletRequest request, 
			HttpServletResponse response)
	{
		ModelAndView mv=null;
		mv=new ModelAndView("managerAccountPassport");
		//String passport=(String)request.getParameter("passport");
		if(passport!=null&&!passport.equals("")){
			
			List<AccountPassport> list=accountPassportService.getAccountsFromPassport( passport, 0, 10);
			if(list!=null&&list.size()==1){
				
				mv.addObject("status",1);
				mv.addObject("accountPassport",list.get(0));
			}else if(list.size()>1){
				mv.addObject("status", 2);
			}else {
				mv.addObject("status", 3);
			}
			
			return mv;
		}
		mv.addObject("status", 0);
		return mv;
	}
	/**
	 * 通行证相关管理(进入编辑或者添加页面)
	 * @param passport(搜狐通行证，参数非必须)
	 */
	@RequestMapping("passport!editPassport.action")
	public ModelAndView edit(@RequestParam(value = "passport", required = false) String  passport,
			HttpServletRequest request, 
			HttpServletResponse response
	){
		ModelAndView mv=null;
		mv=new ModelAndView("accountModify");
		
		List<AccountPassport> accountPassports=accountPassportService.getAccountsFromPassport(passport, 0, 10);
		if(accountPassports!=null&&accountPassports.size()==1){
			mv.addObject("accountPassport", accountPassports.get(0));
		}
		return mv;
	}
	/**
	 * 通行证相关管理(删除)
	 * @param id(搜狐通行证所对应id，参数必须)
	 */
	@RequestMapping("passport!delPassport.action")
	public ModelAndView delete(
			@RequestParam(value = "id", required = true) int  id){
		int count=accountPassportService.deleteAccountPassportById(id);
		ModelAndView mv=new ModelAndView("message");
		String msg=null;
		if(count==1){
			msg="删除成功";
		}else{
			msg="删除失败";
		}
		mv.addObject("msg", msg);
		return mv;
	}
	/**
	 * 通行证相关管理(更新或者添加)
	 * @param passport(搜狐通行证，参数必须)
	 * @param type(必须1表示添加 ,2表示更新)
	 * @param memo备注
	 * @param id
	 * 
	 */
	@RequestMapping("passport!savePassport.action")
	public ModelAndView updatePassport(
			@RequestParam(value = "type", required = true) int  type,
			@RequestParam(value = "passport", required = true) String  passport,
			@RequestParam(value = "memo", required = false) String  memo,
			@RequestParam(value = "id", required = false) String  id,
			//@RequestParam(value = "c_date", required = false) String  c_date,
			HttpServletRequest request, 
			HttpServletResponse response){
		ModelAndView mv=null;
		mv=new ModelAndView("accountModify");
		if(type==1){
			if(passport!=null&&!passport.equals("")){
				AccountPassport accountPassport=new AccountPassport();
				accountPassport.setPassport(passport);
				accountPassport.setMemo(memo);
				int count=accountPassportService.saveAccountPassport(accountPassport);
				
				
				if(count==1){
					mv=new ModelAndView("managerAccountPassport");
					List<AccountPassport> accountPassports=accountPassportService.getAccountsFromPassport(passport, 0, 10);
					if(accountPassports!=null&&accountPassports.size()==1){
						mv.addObject("accountPassport", accountPassports.get(0));
					}
					return mv;
				}
				
			}
			
		}else{
			if(id!=null&&!id.equals("")&&passport!=null&&!passport.equals("")){
				AccountPassport accountPassport=new AccountPassport();
				accountPassport.setPassport(passport);
				accountPassport.setMemo(memo);
				
				accountPassport.setId(Integer.parseInt(id));
				int count=accountPassportService.updateAccountPassport(accountPassport);
				
				if(count==1){
					mv=new ModelAndView("managerAccountPassport");
					List<AccountPassport> accountPassports=accountPassportService.getAccountsFromPassport(passport, 0, 10);
					if(accountPassports!=null&&accountPassports.size()==1){
						mv.addObject("accountPassport", accountPassports.get(0));
					}
					return mv;
				}
				
			}
		}
		return null;
	}
	
	public AccountPassportService getAccountPassportService() {
		return accountPassportService;
	}

	public void setAccountPassportService(AccountPassportService accountPassportService) {
		this.accountPassportService = accountPassportService;
	}
	
}
