package com.example.demo.web;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

import com.example.demo.utils.MyPath;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class UserController {

    // 로그인페이지로 가는컨트롤러
    @GetMapping("/auth/joinPage")
    public String login() {
        return "auth/login";
    }

    @GetMapping("/feed")
    public String feed() {
        return "feed";
    }

    @GetMapping("/send")
    public String send() {
        return "send";
    }

    @PostMapping("/image")
    public @ResponseBody String image(MultipartFile pic) {

        UUID uuid = UUID.randomUUID();
        // 파일이름 찾는 함수
        String imageFileName = uuid + "_" + pic.getOriginalFilename();

        // 사진은 하드에 저장하고
        // 파일이름은 db에 저장하도록한다.

        // \는 윈도우가 이해하는 기법이고 프로그래밍언어에선 /를 사용한다.

        Path imagePath = Paths.get(MyPath.IMAGEPATH + imageFileName);

        try {
            Files.write(imagePath, pic.getBytes());
            // 여기에 db에 파일경로를 저장!! post엔티티
            // 게시글에 사진을 포함시킨다고 하면
            // post에 이미지경로 필드하나 더 해주면 되는것이다.
            // 그럼 jsp에서 image에 src에 post엔티티에있는 이미지 경로를 저장하면 되는것이다.

            // 그럼 path를 db에 저장했을시에 서버를 이전한다고 한다면 경로가 다 틀어질 수 박에없다
            // 그렇기때문에 그냥 경로는 서버가 들고 db에는 경로가 저장돼선 안된다.
            // 그래서 위상황에서 디비에 저장한다고치면imageFileName 를 저장하는것이다.
            // 근데 이미지 파일이름을 저장하게 하면 파일이름이 겹칠수 있다
            // 그래서 UUID uuid = UUID.randomUUID();를 사용하면 중복되면 난수를 발생시킨다.
        } catch (Exception e) {

        }

        return imageFileName;

    }
}
