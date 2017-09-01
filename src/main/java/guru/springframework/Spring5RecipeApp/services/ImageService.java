/**
 * @Author Feng Bo
 * @Date 31 Aug 2017 2:01:22 pm
 */
package guru.springframework.Spring5RecipeApp.services;

import org.springframework.web.multipart.MultipartFile;

/**
 * 
 */
public interface ImageService {

	void saveImageFile(Long recipeId, MultipartFile file);

}
