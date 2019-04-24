package Flight;

public class Home {
	
	
public String home = "\r\n" + 
		"<!DOCTYPE html>\r\n" + 
		"<html {% get_current_language as LANGUAGE_CODE %}lang=\"{{ LANGUAGE_CODE }}\">\r\n" + 
		"  <head>\r\n" + 
		"    \r\n" + 
		"    <meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\" />\r\n" + 
		"    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1, maximum-scale=1, user-scalable=0\"/>\r\n" + 
		"    <meta name=\"created\" content=\"{% now 'jS M Y h:i' %}\" />\r\n" + 
		"    <meta name=\"description\" content=\"{% block meta_description %}{% endblock meta_description %}\" />\r\n" + 
		"    <meta name=\"keywords\" content=\"{% block meta_keywords %}{% endblock meta_keywords %}\"/>\r\n" + 
		"\r\n" + 
		"        <link rel=\"stylesheet\" href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css\" integrity=\"sha384-WskhaSGFgHYWDcbwN70/dfYBj47jz9qbsMId/iRN3ewGhXQFZCSftd1LZCfmhktB\" crossorigin=\"anonymous\">\r\n" + 
		"    \r\n" + 
		"    \r\n" + 
		"  </head>\r\n" + 
		"  <body\r\n" + 
		"      id=\"{% block body_id %}id_body{% endblock body_id %}\"\r\n" + 
		"      class=\"{% block body_class %}{% endblock body_class %}\"\r\n" + 
		"      data-controller=\"{% block data_controller %}{% endblock data_controller %}\"\r\n" + 
		"      data-action=\"{% block data_action %}{% endblock data_action %}\"\r\n" + 
		"    \r\n" + 
		"      >\r\n" + 
		"    <nav class=\"navbar navbar-expand-md navbar-dark bg-dark\">\r\n" + 
		"      <a class=\"navbar-brand\" href=\"#\">Home</a>\r\n" + 
		"      <button class=\"navbar-toggler\" type=\"button\" data-toggle=\"collapse\" data-target=\"#navbarsExampleDefault\" aria-controls=\"navbarsExampleDefault\" aria-expanded=\"false\" aria-label=\"Toggle navigation\">\r\n" + 
		"        <span class=\"navbar-toggler-icon\"></span>\r\n" + 
		"      </button>\r\n" + 
		"\r\n" + 
		"      <div class=\"collapse navbar-collapse\" id=\"navbarsExampleDefault\">\r\n" + 
		"        <ul class=\"navbar-nav mr-auto\">\r\n" + 
		"          <td class=\"nav-item active\">\r\n" + 
		"           <td>\r\n" + 
		"         <a class=\"nav-link\" href=\"localhost:8080/add\">Add test data <span class=\"sr-only\">(current)</span></a>\r\n" + 
		"    \r\n" + 
		"               </td>\r\n" + 
		"          </td>\r\n" + 
		"          \r\n" + 
		"          \r\n" + 
		"      \r\n" + 
		"          \r\n" + 
		"          \r\n" + 
		"         </ul>\r\n" + 
		"      </div>\r\n" + 
		"    </nav>\r\n" + 
		"\r\n" + 
		"    <div class=\"container\">\r\n" + 
		"      \r\n" + 
		"           <table style=\"width:100%\">\r\n" + 
		"  <tr>\r\n" + 
		"    <th>Url</th>\r\n" + 
		"    <th>Description</th>\r\n" + 
		"    </tr>\r\n" + 
		"  <tr>\r\n" + 
		"    <td>localhost:8080/</td>\r\n" + 
		"    <td>Help</td>\r\n" + 
		"    </tr>\r\n" + 
		"  <tr>\r\n" + 
		"    <td>localhost:8080/</td>\r\n" + 
		"    <td>Adding test data</td>\r\n" + 
		"    </tr>\r\n" + 
		"  <tr>\r\n" + 
		"    <td>localhost:8080/find/{departure hh:mm a}</td>\r\n" + 
		"    <td>Display flights at a distance (plus or minus) of 5 hours from the time you select for your departure</td>\r\n" + 
		"    </tr>\r\n" + 
		"  \r\n" + 
		"  \r\n" + 
		"</table> \r\n" + 
		"      \r\n" + 
		"      <footer>\r\n" + 
		"        <hr />\r\n" + 
		"        <p>&copy; Flight Search </p>\r\n" + 
		"      </footer>\r\n" + 
		"    </div class=\"container\">\r\n" + 
		"\r\n" + 
		"    \r\n" + 
		"    <script src=\"https://code.jquery.com/jquery-3.3.1.slim.min.js\" integrity=\"sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo\" crossorigin=\"anonymous\"></script>\r\n" + 
		"    <script src=\"https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js\" integrity=\"sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49\" crossorigin=\"anonymous\"></script>\r\n" + 
		"    <script src=\"https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js\" integrity=\"sha384-smHYKdLADwkXOn1EmN1qk/HfnUcbVRZyYmZ4qpPea6sjB/pTJ0euyQp0Mk8ck+5T\" crossorigin=\"anonymous\"></script>\r\n" + 
		"    \r\n" + 
		"  </body>\r\n" + 
		"</html>\r\n" + 
		"";
}
