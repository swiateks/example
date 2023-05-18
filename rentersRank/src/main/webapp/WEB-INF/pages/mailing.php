<html><body><?php
if (isset($_POST['email']) && !empty($_POST['email'])) {
  $subject = "New contact request: $_POST['subject']";
  $message = $_POST['body'];
  $headers = 'tagopet@wp.pl' . "\r\n" .
             'Reply-To: ' . $_POST['email']. "\r\n" .
             'X-Mailer: PHP/' . phpversion();

  mail('tagopet@wp.pl', $subject, $message, $headers);

  die('Thank you for your email');
}

?>
</body></html>