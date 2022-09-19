package com.example.zhiyi;

import com.example.zhiyi.dao.*;
import com.example.zhiyi.model.*;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@SpringBootTest
@Slf4j
class SpringJpaExampleApplicationTests {
    
    @Autowired
    AuthorRepository authorRepository;
    @Autowired
    ArticleRepository articleRepository;
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private AccountRepository accountRepository;
    @Autowired
    private UsersRepository usersRepository;
    @Autowired
    private AuthorityRepository authorityRepository;
    
    @Test
    public void first_test() {
        this.customerRepository.findById(1L).ifPresent(e -> log.info(String.valueOf(e)));
    }
    
    @Test
    public void test_add() {
        Customer customer = new Customer();
        customer.setCreated_date(new Date());
        customer.setUsername("root");
        customer.setPassword("111111");
        // insert data
        Customer saveCustomer = this.customerRepository.save(customer);
        log.info("saveCustomer = " + saveCustomer);
    }
    
    @Test
    public void test_delete() {
        // delete data
        this.customerRepository.deleteById(2L);
        if (!this.customerRepository.findById(2L).isPresent()) {
            log.info("删除成功");
        } else {
            log.info("删除失败");
        }
    }
    
    @Test
    public void test_a() {
        List<Customer> queryList = this.customerRepository.findByUsernameAndPassword("admin", "111111");
        queryList.forEach(e -> log.info(String.valueOf(e)));
    }
    
    @Test
    public void test_b() {
        List<Customer> queryList = this.customerRepository.findByCondition();
        queryList.forEach(e -> log.info(String.valueOf(e)));
    }
    
    @Test
    public void test_c() {
        int affectedRows = this.customerRepository.updateByCondition("obama", 3L);
        log.info("affectedRows = " + affectedRows);
    }
    
    @Test
    public void test_d() {
        List<Customer> queryList = this.customerRepository.findByCondition2("obama", "111111");
        queryList.forEach(e -> log.info(String.valueOf(e)));
    }
    
    @Test
    public void test_e() {
        // new AccountDetail
        AccountDetail accountDetail = new AccountDetail();
        accountDetail.setPhone("17600000000");
        accountDetail.setRealName("zhiyi yuan");
        accountDetail.setAddress("Asia/Shanghai");
        accountDetail.setEmail("admin@gmail.com");
        // new Account
        Account account = new Account();
        account.setUsername("zhiyi98");
        account.setPassword("111111");
        account.setDetail(accountDetail);// OneToOne
        // insert database
        Account save = this.accountRepository.save(account);
        // logger
        log.info("插入之后account id={}，accountDetail id={}", save.getId(), save.getDetail().getId());
    }
    
    @Test
    public void test_f() {
        this.accountRepository.deleteById(4L);
    }
    
    @Test
    public void test_g() {
        // insert Author
        Author author = new Author();
        author.setName("zhiyi yuan");
        Author saveAuthor = this.authorRepository.save(author);
        // insert Article
        Article article = new Article();
        article.setTitle("SpringJPA");
        article.setContent("Hello,jpa.");
        article.setAuthor(saveAuthor);
        this.articleRepository.save(article);
        // insert Article
        Article newArticle = new Article();
        newArticle.setTitle("Hibernate");
        newArticle.setContent("Hello,hibernate.");
        newArticle.setAuthor(saveAuthor);
        this.articleRepository.save(newArticle);
    }
    
    @Test
    public void test_h() {
        this.articleRepository.deleteById(9L);
    }

    @Transactional
    @Test
    public void test_i() {
        Optional<Author> byId = this.authorRepository.findById(10L);
        if (byId.isPresent()) {
            Author author = byId.get();
            List<Article> articleList = author.getArticleList();
            log.info("articleList={}", articleList);
        }
    }
    
    @Test
    public void test_j() {
        Authority authority = new Authority();
        authority.setId(1L);
        authority.setName("ROLE_ADMIN");
        this.authorityRepository.save(authority);
    }
    
    @Test
    public void test_k() {
        Users users = new Users();
        users.setUsername("zhiyi yuan");
        users.setPassword("111111");
        //noinspection OptionalGetWithoutIsPresent
        Authority authority = this.authorityRepository.findById(1L).get();
        List<Authority> authorityList = new ArrayList<>();
        authorityList.add(authority);
        users.setAuthorityList(authorityList);
        this.usersRepository.save(users);
    }
    
    @Test
    public void test_l() {
        this.usersRepository.deleteById(1L);
    }
    
    
}
