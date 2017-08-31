/**
 * @Author Feng Bo
 * @Date 31 Aug 2017 2:02:01 pm
 */
package guru.springframework.Spring5RecipeApp.services;

import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

/**
 * 
 */
@Slf4j
@Service
public class ImageServiceImpl implements ImageService {

	@Override
	public void saveImageFile(long anyLong, Object any) {
		// TODO Auto-generated method stub
		log.debug("Received a file");
	}

}
