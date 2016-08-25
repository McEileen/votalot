user votalot;

set FOREIGN_KEY_CHECKS = 0;
truncate table voters;
truncate table candidates;
set FOREIGN_KEY_CHECKS = 1;

INSERT INTO `votalot`.`voters` (`name`, `race`, `gender`)
VALUES
  ('Tom', 'BLACK', 'M'),
  ('Sara', 'WHITE', 'F'),
  ('Lisa', 'BLACK', 'F'),
  ('Sprinkles', 'BLACK', 'F'),
  ('Trisha', 'ASIAN', 'F'),
  ('Mark', 'MULTIRACIAL', 'M'),
  ('Stephanie', 'WHITE', 'M'),
  ('Nora', 'ASIAN', 'F'),
  ('Matt', 'ASIAN', 'M'),
  ('Shea', 'INDIGENOUS', 'M'),
  ('Krissy', 'WHITE', 'F'),
  ('Gladys', 'WHITE', 'F'),
  ('Howard', 'BLACK', 'M');

INSERT INTO `votalot`.`candidates` (`name`, `party`, `contest`)
VALUES
  ('Tommy', 'D', '1'),
  ('Sarita', 'D', '1'),
  ('MonaLisa', 'I', '1'),
  ('@Sprinkles', 'R', '1');


INSERT INTO `votalot`.`contests` (`position`, `created_at`, `updated_at`)
VALUES
  ('Mayor of Chicago', '2016-03-03', '2016-03-03'),
  ('President of The US', '2016-03-03', '2016-03-03'),
  ('Senator, IL', '2016-03-03', '2016-03-03'),
  ('Chicago City Council', '2016-03-03', '2016-03-03'),
  ('Chicago School Board', '2016-03-03', '2016-03-03');