# Light Excel Reader
A lightweight Java Framework that can be used to read XLSX Excel files.
A lot of software applications contain features whose sole purpose is to just read data from XLSX files for which they need to rely on existing heavyweight frameworks with additional dependencies. This framework's sole purpose is to help users to read data from .xlsx files.
## Dependencies
 - None
## Java Requirements
 - Java 8+
## Supported File Types
 - XLSX
## Features
 - Reading Excel files sheet by sheet, row by row, and cell by cell.
 - Mapping Excel file data into Java object models.
### Reading Excel Files
This will allow you to read an XLSX file, generate a <code>WorkBook</code> object out of it. You can access available data on sheets, rows, and cells from that. Currently, data from all the cells are available in String format only, future additions may be made to return cell values in other types.
### Object Model Mapping
This makes use of the feature to read the excel files to convert your excel sheet to a list of POJO objects or convert your entire excel workbook to a POJO object containing a group of lists each containing values from individual excel sheets within the excel workbook.
## Getting Started
### Reading Excel Files
To generate a <code>WorkBook</code> object from your .xlsx file, all you need to do is simply execute the following code:
<code>WorkBook workBook = WorkBookFactory.create("D://file.xlsx");</code>
#### Constraints
 - All cell values will be returned in <code>String</code> format.
 - Date values in cells may not be working properly(you can convert the cells in the excel file to text type to make this work).
 - Excel file being read should not be open by Microsoft Excel or some other application when this framework is reading the data.
### Java Object Model Mapping For Single Sheet
To generate a list of custom Java objects for a sheet in the excel file, you need to use the <code>ExcelColumn</code> annotation. In your model class, annotate the properties which you would like to bind with the excel data. For example:

    class Employee {
        @ExcelColumn(name = "First Name")
	    private String firstName;
	
	    @ExcelColumn(name = "Last Name")
	    private String lastName;
	
	    @ExcelColumn(name = "Address")
	    private String address;
	
	    public String getFirstName() {
	        return firstName;
	    }
	
	    public String getLastName() {
	        return lastName;
	    }
	
	    public String getAddress() {
	        return address;
	    }
    }
Now, simply use the <code>ExcelObjectMapper</code> class to convert a <code>Sheet</code> object to a <code>List</code> of <code>Employee</code> objects. The value of the <code>name</code> function of the <code>@ExcelColumn</code> annotation must be exactly the same as the expected header row cell value in the excel sheet.
#### Constraints
  - All the <code>@ExcelColumn</code> annotated properties in the Java data model class should be of type <code>String</code>.
  - <code>name</code> is case sensitive.
### Java Object Mapping for Multiple Sheets
To generate a custom Java object model from the <code>WorkBook</code> you need to create a Java data model class containing <code>List</code> objects annotated with the <code>@ExcelSheet</code>. Each list object will represent rows within a sheet. Example:

    class Company {
        @ExcelSheet(name = "Employee")
        private List<Employee> employees;

        @ExcelSheet(name = "Staff")
        private List<Staff> staff;
        
        public List<Employee> getEmployees() {
            return employees;
        }
        
        public List<Staff> getStaff() {
            return staff;
        }
    }
The value of the <code>name</code> function of the <code>@ExcelSheet</code> annotation should be the exact sheet name of the excel file.
#### Constraints
  - The first non-empty row of every sheet must be the header row.
  - <code>name</code> is case sensitive.
### Logging
In case the required objects are not generated, a <code>null</code> value or an empty <code>List</code>is returned. Framework currently does not percolate the exceptions thrown but unstead logs exceptions. Logging is disabled by default, but in order to enable or disable logging, simply use the <code>ExcelReaderLogger.enableLogging(true)</code>. The parameter accepts boolean type to enable or disable logging.
