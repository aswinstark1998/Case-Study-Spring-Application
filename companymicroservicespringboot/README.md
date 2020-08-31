# Spring Boot Company microservice

  Microservice to retrieve data of a company, for certain period, 


#STOCK PRICE TABLE
#getCompanyStockPrice
#i/p Company ID, From Period, To Period, periodicity(Week or Month or Quarter or Year)
#/stockprice/cid/{cid}/from/{fromdate}/to/{todate}

COMPANY TABLE
#getMatchingCompanies – used to retrieve list of Companies based on pattern matching of Company Name 
#i/p : text
#/searchcompany/{pat}
#getCompanyDetails – Basic information about company
#i/p Company Name
#/company/details/
#addCompanyDetails  POST
#Entire row
#company/insert/
#UpdateCompanyDetails PUT (Deactivate or Edit Company)
#Entire row with changed values
#company/update/
#DeactivateCompanyDetails
#/deactivate/{id}


#IPO TABLE	
#getCompanyIPODetails – IPODetails of Company GET
#Display entire table ORDER by Date
#rest/IPO/all/{name}/
#updateIPODetails POST
Adding Entire row
#update/{arguments}
